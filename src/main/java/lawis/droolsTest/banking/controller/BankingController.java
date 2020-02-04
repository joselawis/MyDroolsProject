package lawis.droolsTest.banking.controller;

import lawis.droolsTest.banking.service.RuleRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankingController {

    private final RuleRunner ruleRunner;

    @Autowired
    public BankingController(RuleRunner ruleRunner) {
        this.ruleRunner = ruleRunner;
    }

    @RequestMapping(value = "/banking1", method = RequestMethod.GET, produces = "application/json")
    public void example1() {
        ruleRunner.runRules(new String[] {
                "rules/droolsTest/banking/Example1.xls"}, new Object[0]);
    }

    @RequestMapping(value = "/banking2", method = RequestMethod.GET, produces = "application/json")
    public void example2() {
        Number[] numbers = new Number[] {wrap(3), wrap(1), wrap(4), wrap(1), wrap(5)};
        ruleRunner.runRules(new String[] {
                "rules/droolsTest/banking/Example2.xls"}, numbers);
    }

    private static Integer wrap( int i ) {
        return new Integer(i);
    }
}
