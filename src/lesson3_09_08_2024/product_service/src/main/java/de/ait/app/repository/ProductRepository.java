package de.ait.app.repository;

import de.ait.app.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
@Component
public class ProductRepository implements ProductRepositoryImp{

    List<Product> db = List.of(
            new Product (1L,"Banana", new BigDecimal("0.90"), "article"),
            new Product (2L,"Apple", new BigDecimal("1.90"), "article1"),
            new Product (3L,"Tomato", new BigDecimal("2.30"), "article2"),
            new Product (4L,"Milk", new BigDecimal("0.95"), "article3")

            );
    @Override
    public List<Product> findAll() {
        return db;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product delete(Product product) {
        return null;
    }
}
