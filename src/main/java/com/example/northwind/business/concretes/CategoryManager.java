package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.dataAccess.abstracts.CategoryRepository;
import com.example.northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public Category findById(int categoryId) {
        return categoryRepository.getById(categoryId);
    }


    public Category add( Category category) {
        return categoryRepository.save(category);
    }


    public Category update(int id, Category category) {
        Category categoryUpToDate = categoryRepository.getById(id);

        categoryUpToDate.setCategoryName(category.getCategoryName());
        categoryUpToDate.setDescription(category.getDescription());
        categoryUpToDate.setPicture(category.getPicture());

        return categoryRepository.save(categoryUpToDate);
    }

    public Category delete(int id) {
        Category categoryToDelete = categoryRepository.getById(id);
        categoryRepository.delete(categoryToDelete);
        return categoryToDelete;
    }
}
