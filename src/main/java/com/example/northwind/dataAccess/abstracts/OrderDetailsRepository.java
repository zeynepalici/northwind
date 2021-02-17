package com.example.northwind.dataAccess.abstracts;

import com.example.northwind.entities.concretes.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {
    List<OrderDetails> getAllByOrderId(int orderId);

}
