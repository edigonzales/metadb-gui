package ch.so.agi.metadb.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
//@ViewScoped
@RequestScoped
public class ProductView {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ProductService productService;
    
    public ProductView(ProductService productService) {
        this.productService = productService;
    }
    
    public List<Product> getProducts() {
        return productService.findAll();
    } 
}
