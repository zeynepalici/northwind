package com.example.northwind.business.abstracts;

import com.example.northwind.entities.concretes.ShoppingCart;
import com.example.northwind.entities.concretes.ShoppingCartItem;

import java.util.List;

public interface IShoppingCartService {
    ShoppingCart delete(int id);
    ShoppingCartItem deleteProductOfTheShoppingCart(String customerId, int productId, int quantity);
    ShoppingCartItem addProductToTheShoppingCart(String customerId, int productId);
    List<ShoppingCartItem> getAllItemsOfTheShoppingCart(String customerId);
}
