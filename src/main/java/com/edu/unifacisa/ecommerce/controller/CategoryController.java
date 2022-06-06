package com.edu.unifacisa.ecommerce.controller;

import com.edu.unifacisa.ecommerce.model.Category;
import com.edu.unifacisa.ecommerce.model.Product;
import com.edu.unifacisa.ecommerce.service.CategoryService;
import com.edu.unifacisa.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> getCategories () {
        return categoryService.findAll();
    }

    @PostMapping("/insert")
    public void insertCategory (@RequestBody Category category) {
        categoryService.insertCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory (@PathVariable long id) {
        categoryService.deleteCatgory(id);
    }

    @GetMapping("{id}")
    public Category findById (@PathVariable long id) {
        return categoryService.findById(id);
    }

    @PutMapping("/atualiza={id}")
    public void atualizaCategory (@PathVariable long id, @RequestBody Category category) {
        categoryService.atualizaProduct(id, category);
    }

}
