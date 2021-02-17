package com.example.northwind.dataAccess.abstracts;

import com.example.northwind.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> getAllByCustomerId(String customerId);
    Order getByOrderId(int orderId);

}
