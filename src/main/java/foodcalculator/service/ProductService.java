package foodcalculator.service;

import foodcalculator.exception.ResourceNotFoundException;
import foodcalculator.model.Product;
import foodcalculator.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.image.RasterFormatException;
import java.util.List;

@Service
public class ProductService {

   private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
       return productRepository.save(product);
    }

    public Product updateProduct(long id, Product product){
       return productRepository.findById(id).map(p ->{

            p.setProtein(product.getProtein());
            p.setFat(product.getFat());
            p.setCarbohydrates(product.getCarbohydrates());
            p.setKcal(product.getKcal());
            p.setName(product.getName());
            return productRepository.save(p);
        }).orElseThrow(() -> new RasterFormatException("product by id: "+ id + " not found"));
    }

    public ResponseEntity<?> deleteProduct(long id){
        return productRepository.findById(id).map(p -> {
            productRepository.deleteById(id);
            return new ResponseEntity<>("product by id " + id+ " was deletes!", HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("product by id " + id+ " not found"));
    }
    public Product getProductById(long id){
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product by id " + id + " not found"));
    }
}
