package uk.co.ourfriendirony.springdemo.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.co.ourfriendirony.springdemo.objects.Product;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    private ObjectMapper mapper = new ObjectMapper();

    private final String baseUrl = "/products/v1";

    @Autowired
    private MockMvc mvc;

    @Test
    public void postProduct() throws Exception {
        Product p = new Product("mydesc", "mysku");

        mvc.perform(MockMvcRequestBuilders
                .post(baseUrl + "/productId")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(p.toString())
        ).andExpect(status()
                .is(201)
        );
    }

    @Test
    public void getProductByParam() throws Exception {
        Product p = new Product("mydesc", "123246");

        mvc.perform(MockMvcRequestBuilders
                .get(baseUrl + "/productId")
                .accept(MediaType.APPLICATION_JSON)
                .param("sku", "123246")
        ).andExpect(status()
                .is(200)
        ).andExpect(content()
                .string(equalTo(p.toString()))
        );
    }
}
