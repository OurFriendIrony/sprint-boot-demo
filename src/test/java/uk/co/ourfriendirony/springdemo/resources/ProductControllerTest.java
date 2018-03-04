package uk.co.ourfriendirony.springdemo.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @Test
    public void postProduct() throws Exception {
        Product p = getProduct("mydesc","mysku");

        mvc.perform(MockMvcRequestBuilders
                .post(baseUrl + "/productId")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(pojoToString(p))
        ).andExpect(status().is(201));
    }

    private String pojoToString(Product p) throws JsonProcessingException {
        return mapper.writeValueAsString(p);
    }

    private Product getProduct(String desc, String sku) {
        Product p = new Product();
        p.setDescription(desc);
        p.setSku(sku);
        return p;
    }
}
