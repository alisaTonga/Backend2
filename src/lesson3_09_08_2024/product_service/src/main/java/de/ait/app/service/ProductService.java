package de.ait.app.service;

import de.ait.app.entity.Product;
import de.ait.app.repository.ProductRepository;
import de.ait.app.repository.ProductRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService implements ProductServiceInt{
    private final ProductRepositoryImp repository;
    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findAll()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .get();
    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
