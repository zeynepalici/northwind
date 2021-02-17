package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.IOrderService;
import com.example.northwind.dataAccess.abstracts.OrderRepository;
import com.example.northwind.entities.concretes.ShoppingCartItem;
import com.example.northwind.entities.concretes.Order;
import com.example.northwind.entities.concretes.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManager implements IOrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ShoppingCartManager cardManager;

    @Autowired
    OrderDetailsManager orderDetailsManager;


    @Override
    public Order add(Order order) {
        List<ShoppingCartItem> shoppingCartItems = cardManager.getAllItemsOfTheShoppingCart(order.getCustomerId());

        orderRepository.save(order);

        for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderId(order.getOrderId());
            orderDetails.setProductId(shoppingCartItem.getProductId());
            orderDetails.setQuantity(shoppingCartItem.getQuantity());
            orderDetailsManager.add(orderDetails);
        }
        cardManager.clearShoppingCart(order.getCustomerId());
        return order;
    }

    @Override
    public List<Order> getAllByCustomerId(String customerId) {
        return orderRepository.getAllByCustomerId(customerId);
    }


    @Override
    public Order findById(int orderId) {
        return orderRepository.getByOrderId(orderId);
    }

}
