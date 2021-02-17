package com.example.northwind.business.abstracts;

import com.example.northwind.entities.concretes.OrderDetails;

public interface IOrderDetailsService {
    OrderDetails add(OrderDetails orderDetails);
    OrderDetails update (int id, OrderDetails orderDetails);
    OrderDetails findById(int id);
    OrderDetails delete(int id);
}
