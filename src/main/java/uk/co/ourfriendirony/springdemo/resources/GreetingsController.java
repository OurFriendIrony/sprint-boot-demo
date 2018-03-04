package uk.co.ourfriendirony.springdemo.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.Contact;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
