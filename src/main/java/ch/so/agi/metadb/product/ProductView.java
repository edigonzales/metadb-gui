package ch.so.agi.metadb.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
//@RequestScoped
public class ProductView implements Serializable {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String filter;

    private ProductService productService;
    
    public ProductView(ProductService productService) {
        this.productService = productService;
    }
    
    public List<Product> getProducts() {
        if (filter == null || filter.length() < 3) {
            return productService.findAll();            
        } else {
            return productService.findByFilter(filter);
        }
    }
    
    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
