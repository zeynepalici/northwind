package com.example.northwind.business.abstracts;

import com.example.northwind.entities.concretes.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product add(Product product);
    Product update (int productId, Product product);
    Product findById(int id);
    Product delete(int id);
}
