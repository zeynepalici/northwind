package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.IOrderService;
import com.example.northwind.entities.concretes.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1") // version1
public class OrdersController {

    @Autowired
    IOrderService orderService;


    @PostMapping("/orders")
    public Order add(@RequestBody Order order) {
        return orderService.add(order);
    }


    @GetMapping("/orders/{customerId}")
    public List<Order> getAllByCustomerId(@PathVariable String customerId) {
        return orderService.getAllByCustomerId(customerId);
    }
}
