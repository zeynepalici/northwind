package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1") // version1
public class ProductsController {

    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping("/products")
    public Product add(@RequestBody Product product) {
      return productService.add(product);
    }


    @PutMapping("/products/{id}")
    public Product update(@PathVariable(value = "id") int productId,
                          @RequestBody Product product) throws Exception {
      return  productService.update(productId,product);
    }


    @GetMapping("/productsById/{id}")
    public Product findById(@PathVariable(value = "id") int id) {
        return productService.findById(id);
    }

    @DeleteMapping("/products/{id}")
    public Product delete(@PathVariable(value = "id") int id) {
        return productService.delete(id);
    }
}
