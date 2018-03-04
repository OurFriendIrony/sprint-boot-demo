package uk.co.ourfriendirony.springdemo.resources;

import org.apache.log4j.Logger;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.ourfriendirony.springdemo.objects.Product;

@RestController
@RequestMapping("/products/v1")
public class ProductController {
    final Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/productId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> postProduct(RequestEntity<Product> requestEntity) {
        Product product = requestEntity.getBody();
        logger.info(product.toString());

        product.setDescription(product.getDescription() + " output");
        product.setSku(product.getSku() + " output");

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity<>(product, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/productId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@RequestParam("sku") String paramSku) {
        Product product = new Product("mydesc", paramSku);
        logger.info(product.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity<>(product, headers, HttpStatus.OK);
    }
}
