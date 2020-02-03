package lawis.droolsTest.state.service;

import lawis.droolsTest.DroolsUtils;
import lawis.droolsTest.state.model.State;
import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    private final KieContainer kieContainer;

    @Autowired
    public StateService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public void state() {
        KieSession ksession = kieContainer.newKieSession("StateKS");
//        The application can also setup listeners
//        ksession.addEventListener(new DebugAgendaEventListener());
//        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        final State a = new State("A");
        final State b = new State("B");
        final State c = new State("C");
        final State d = new State("D");

        ksession.insert(a);
        ksession.insert(b);
        ksession.insert(c);
        ksession.insert(d);


        //Leemos el archivo de reglas desde una planilla Excel
        DroolsUtils.PrintDRL(getClass().getClassLoader(),
                "rules/droolsTest/State/State.xls");

//        ​and fire the rules
        ksession.fireAllRules();

        ksession.dispose();

    }
}
