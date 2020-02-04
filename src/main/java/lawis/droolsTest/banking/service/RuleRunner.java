package lawis.droolsTest.banking.service;


import lawis.droolsTest.DroolsUtils;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleRunner {

    @Autowired
    public RuleRunner() {
    }

    public void runRules(String[] rules, Object[] facts) {
        KieSession kieSession = DroolsUtils.prepareRules(rules, facts);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
