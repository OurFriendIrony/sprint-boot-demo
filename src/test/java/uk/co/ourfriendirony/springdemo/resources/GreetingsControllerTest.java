package uk.co.ourfriendirony.springdemo.resources;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingsControllerTest {

    private final String baseUrl = "/greetings/v1";

    @Autowired
    private MockMvc mvc;

    @Test
    public void getIndexMessage() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get(baseUrl + "/")
                .accept(MediaType.TEXT_PLAIN)
        ).andExpect(status()
                .isOk()
        ).andExpect(content()
                .string(equalTo("Greetings from Spring Boot!"))
        );
    }

    @Test
    public void getUserMessage() throws Exception {
        String name = RandomStringUtils.randomAlphanumeric(10);
        mvc.perform(MockMvcRequestBuilders
                .get(baseUrl + "/" + name)
                .accept(MediaType.TEXT_PLAIN)
        ).andExpect(status()
                .isOk()
        ).andExpect(content()
                .string(equalTo(String.format("Greetings %s from Spring Boot!", name)))
        );
    }
}
