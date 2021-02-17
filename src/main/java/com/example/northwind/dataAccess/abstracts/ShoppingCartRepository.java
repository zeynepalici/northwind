package com.example.northwind.dataAccess.abstracts;

import com.example.northwind.entities.concretes.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
ShoppingCart getById(int id);
ShoppingCart getByCustomerId(String customerId);

}
