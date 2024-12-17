package netmehdi.auctionapp.controllers;

import netmehdi.auctionapp.entities.Product;
import netmehdi.auctionapp.services.ProductServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductServiceImp productService;

    public ProductController(ProductServiceImp productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
    //-----------------------

//
////    @GetMapping("/active")
////    public List<Product> getActiveProducts() {
////        return productService.getActiveProducts();
////    }
//    @GetMapping("/products")
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }
//
//    @PostMapping("/createProduct")
//    public Product createProduct(@RequestBody Product product) {
//        return productService.createProduct(product);
//    }
}