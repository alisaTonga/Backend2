package de.ait.app.repository;

import de.ait.app.entity.Product;

import java.util.List;

public interface ProductRepositoryImp {
    List<Product> findAll();
    Product save (Product product);
    Product delete (Product product);
}
