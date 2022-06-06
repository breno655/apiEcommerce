package com.edu.unifacisa.ecommerce.service;

import com.edu.unifacisa.ecommerce.model.Product;
import com.edu.unifacisa.ecommerce.model.User;
import com.edu.unifacisa.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void insertProduct (Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll () {
        return productRepository.findAll();
    }

    public Product findById (long id) {
        return productRepository.findById(id).get();
    }

    public void deleteProduct (long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    public void atualizaProduct (long id, Product product) {
        deleteProduct(id);
        product.setId(id);
        insertProduct(product);
    }

}
