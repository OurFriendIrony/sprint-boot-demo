package uk.co.ourfriendirony.springdemo.resources;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uk.co.ourfriendirony.springdemo.objects.Product;

@RestController
@RequestMapping("/products/v1")
public class ProductController {


    @RequestMapping(value = "/productId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> postProduct(RequestEntity<Product> requestEntity) {

        Product product = requestEntity.getBody();
        product.setDescription(product.getDescription() + " output");
        product.setSku(product.getSku() + " output");

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity<>(product, headers, HttpStatus.ACCEPTED);
    }
}
