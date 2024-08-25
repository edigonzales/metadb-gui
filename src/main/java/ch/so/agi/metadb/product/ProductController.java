package ch.so.agi.metadb.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/products")
    public void getProducts() {
        
        
    }
    
}
