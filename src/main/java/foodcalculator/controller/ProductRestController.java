package foodcalculator.controller;

import foodcalculator.model.Product;
import foodcalculator.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    private ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products/")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/api/products/")
    public Product createProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/api/products/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/api/products({id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);
    }
}
