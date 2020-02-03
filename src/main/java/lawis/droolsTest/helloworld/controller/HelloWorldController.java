package lawis.droolsTest.helloworld.controller;

import lawis.droolsTest.helloworld.model.Message;
import lawis.droolsTest.helloworld.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET, produces = "application/json")
    public void getQuestions() {

        final Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);

        helloWorldService.helloWorld(message);
    }
}