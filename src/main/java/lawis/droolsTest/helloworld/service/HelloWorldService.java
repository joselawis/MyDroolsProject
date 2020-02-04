package lawis.droolsTest.helloworld.service;

import lawis.droolsTest.DroolsUtils;
import lawis.droolsTest.helloworld.model.Message;
import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    private final KieContainer kieContainer;

    @Autowired
    public HelloWorldService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public String helloWorld(Message message) {
        KieSession ksession = kieContainer.newKieSession("HelloWorldKS");
//        The application can also setup listeners
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        ksession.insert( message );

        //Leemos el archivo de reglas desde una planilla Excel
        DroolsUtils.PrintDRL("rules/droolsTest/HelloWorld/HelloWorld.xls");

//        ​and fire the rules
        ksession.fireAllRules();

        return message.getMessage();
    }
}
