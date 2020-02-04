package lawis.droolsTest.backwardchaining.controller;

import lawis.droolsTest.backwardchaining.service.HouseOfDoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseOfDoomController {

    private final HouseOfDoomService houseOfDoomService;

    @Autowired
    public HouseOfDoomController(HouseOfDoomService houseOfDoomService) {
        this.houseOfDoomService = houseOfDoomService;
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET, produces = "application/json")
    public void getQuestions() {
        houseOfDoomService.play();
    }
}