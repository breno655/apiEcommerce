package com.edu.unifacisa.ecommerce.service;

import com.edu.unifacisa.ecommerce.model.Category;
import com.edu.unifacisa.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void insertCategory (Category category) {
        categoryRepository.save(category);
    }

    public List<Category> findAll () {
        return categoryRepository.findAll();
    }

    public Category findById (long id) {
        return categoryRepository.findById(id).get();
    }

    public void deleteCatgory (long id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
    }

    public void atualizaProduct (long id, Category category) {
        deleteCatgory(id);
        category.setId(id);
        insertCategory(category);
    }

}
