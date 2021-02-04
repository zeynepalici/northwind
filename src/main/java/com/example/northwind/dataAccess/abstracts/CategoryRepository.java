package com.example.northwind.dataAccess.abstracts;

import com.example.northwind.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category getById(int categoryId);

}
