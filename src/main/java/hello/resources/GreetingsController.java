package hello.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/greetings/v1")
public class GreetingsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
    public String user(@PathVariable("userid") String userid) {
        return String.format("Greetings %s from Spring Boot!", userid);
    }
}