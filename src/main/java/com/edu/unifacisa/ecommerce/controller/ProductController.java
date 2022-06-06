package com.edu.unifacisa.ecommerce.controller;

import com.edu.unifacisa.ecommerce.model.Product;
import com.edu.unifacisa.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getProducts () {
        return productService.findAll();
    }

    @PostMapping("/insert")
    public void insertProduct (@RequestBody Product product) {
        productService.insertProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct (@PathVariable long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("?{id}")
    public Product findById (@PathVariable long id) {
        return productService.findById(id);
    }

    @PutMapping("/atualiza={id}")
    public void atualizaProduct (@PathVariable long id, @RequestBody Product product) {
        productService.atualizaProduct(id, product);
    }

}
