package uk.co.ourfriendirony.springdemo.resources;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings/v1")
public class GreetingsController {
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getIndexMessage() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getUserMessage(@PathVariable("username") String username) {
        return String.format("Greetings %s from Spring Boot!", username);
    }
}
