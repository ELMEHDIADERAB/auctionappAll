package netmehdi.auctionapp.services;

import netmehdi.auctionapp.entities.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    Product createProduct(Product product);
    List<Product> getAllProducts();
    void deleteProductById(Long id);
}
