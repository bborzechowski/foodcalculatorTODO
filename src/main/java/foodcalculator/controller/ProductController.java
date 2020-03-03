package foodcalculator.controller;


import foodcalculator.model.Product;
import foodcalculator.repository.ProductRepository;
import foodcalculator.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private ProductRepository productRepository;
    private ProductService productService;
    //   private Product product;


    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

//    @GetMapping("/food")
//    public String home(){
//        return "form";
//    }

    @PostMapping("/food/add")
    public String addProduct(@ModelAttribute Product newProduct){
        Product product= new Product();
        product.setName(newProduct.getName());
        product.setKcal(newProduct.getKcal());
        product.setProtein(newProduct.getProtein());
        product.setFat(newProduct.getFat());
        product.setCarbohydrates(newProduct.getCarbohydrates());
        productRepository.save(product);
        System.out.println(product);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
    //    return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
        return "product-index";
    }

    @GetMapping("/products/delate")
    public String deleteProduct(@RequestParam long id){
        productRepository.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/products/update")
    public String updateProduct(@RequestParam long id, Model model){

        Product product = productService.getProductById(id);

        if(product == null){
            return "Cannot find product";
        }
        model.addAttribute("product", product);
        return "product-update";
    }

    @PostMapping("/products/update/confirm")
    public String updateProductConfirm(@ModelAttribute Product incomeProduct){

        Product product = new Product();
        product.setId(incomeProduct.getId());
        product.setName(incomeProduct.getName());
        product.setKcal(incomeProduct.getKcal());
        product.setCarbohydrates(incomeProduct.getCarbohydrates());
        product.setFat(incomeProduct.getFat());
        product.setProtein(incomeProduct.getProtein());
        productRepository.save(incomeProduct);
        String operationResult = productService.updateProduct(incomeProduct.getId(),product).getName();
        return "redirect:/products??message=updated product: " + operationResult;
    }
}
