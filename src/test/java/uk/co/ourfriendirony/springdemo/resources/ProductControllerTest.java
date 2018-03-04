package uk.co.ourfriendirony.springdemo.resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.co.ourfriendirony.springdemo.objects.Product;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    private final String baseUrl = "/products/v1";

    @Autowired
    private MockMvc mvc;

    @Test
    public void postProduct() throws Exception {
        Product p = new Product();
        p.setDescription("test");
        p.setSku("skutest");

        mvc.perform(MockMvcRequestBuilders
                .post(baseUrl + "/productId")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(p.toString())
        ).andExpect(status().is(202));
    }
}