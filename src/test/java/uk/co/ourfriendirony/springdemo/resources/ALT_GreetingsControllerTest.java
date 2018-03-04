package uk.co.ourfriendirony.springdemo.resources;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ALT_GreetingsControllerTest {

    private final String baseUrl = "/greetings/v1";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;
    private URL base;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + baseUrl);
    }

    @Test
    public void getIndexMessage() {
        ResponseEntity<String> response = template.getForEntity(base.toString() + "/", String.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
    }

    @Test
    public void getUserMessage() {
        String name = RandomStringUtils.randomAlphanumeric(10);
        ResponseEntity<String> response = template.getForEntity(base.toString() + "/" + name, String.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody(), equalTo(String.format("Greetings %s from Spring Boot!", name)));
    }
}