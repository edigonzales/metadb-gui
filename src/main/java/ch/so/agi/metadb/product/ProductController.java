package ch.so.agi.metadb.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/products")
    public List<Product> getProducts() {
        List<Product> products = productService.findAll();
        return products;
    }
}
