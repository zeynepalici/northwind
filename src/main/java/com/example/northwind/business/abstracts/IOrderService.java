package com.example.northwind.business.abstracts;

import com.example.northwind.entities.concretes.Category;
import com.example.northwind.entities.concretes.Order;

import java.util.List;

public interface IOrderService {
    Order add(Order order);
    Order findById(int id);
    List<Order> getAllByCustomerId(String customerId);
}
