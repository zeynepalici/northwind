package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.IOrderDetailsService;
import com.example.northwind.dataAccess.abstracts.OrderDetailsRepository;
import com.example.northwind.entities.concretes.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsManager implements IOrderDetailsService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderDetails add(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetails update(int id, OrderDetails orderDetails) {
        return null;
    }

    @Override
    public OrderDetails findById(int id) {
        return null;
    }

    @Override
    public OrderDetails delete(int id) {
        return null;
    }
}
