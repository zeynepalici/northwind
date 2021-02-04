package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class CategoriesController {

    @Autowired
    ICategoryService categoryService;


    @PostMapping("/categories")
    public Category add(@RequestBody Category category) {
        return categoryService.add(category);
    }


    @PutMapping("/categories/{id}")
    public Category update(@PathVariable(value = "id") int categoryId,
                           @RequestBody Category category) throws Exception {
        return categoryService.update(categoryId, category);
    }


    @GetMapping("/categoriesById/{id}")
    public Category findById(@PathVariable(value = "id") int id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("/categories/{id}")
    public Category delete(@PathVariable(value = "id") int id) {
        return categoryService.delete(id);
    }
}
