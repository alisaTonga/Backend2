package de.ait.app.service;

import de.ait.app.entity.Product;

import java.util.List;

public interface ProductServiceInt {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product save(Product product);

}
