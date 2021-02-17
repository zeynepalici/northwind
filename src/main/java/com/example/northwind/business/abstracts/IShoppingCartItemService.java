package com.example.northwind.business.abstracts;

import com.example.northwind.entities.concretes.ShoppingCartItem;

import java.util.List;

public interface IShoppingCartItemService {
    ShoppingCartItem add(ShoppingCartItem shoppingCartItem);
    ShoppingCartItem update(int cardItemId, ShoppingCartItem shoppingCartItem);
    ShoppingCartItem delete(int id);
    ShoppingCartItem deleteProductFromShoppingCartItem(int cardId, int productId, int quantity);
    ShoppingCartItem addProductToShoppingCartItem(int cardId, int productId);
    List<ShoppingCartItem> getAll();
    List<ShoppingCartItem> getAllProductsOfTheShoppingCart(int cardId);
}
