package lawis.droolsTest.state.controller;

import lawis.droolsTest.state.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @RequestMapping(value = "/state", method = RequestMethod.GET, produces = "application/json")
    public void getQuestions() {
        stateService.state();
    }
}