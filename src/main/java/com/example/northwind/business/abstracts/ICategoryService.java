package com.example.northwind.business.abstracts;

import com.example.northwind.entities.concretes.Category;

public interface ICategoryService {

    Category add(Category category);
    Category update (int categoryId, Category category);
    Category findById(int id);
    Category delete(int id);
}
