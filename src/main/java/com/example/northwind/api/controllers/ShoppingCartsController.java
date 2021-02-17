package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.IShoppingCartService;
import com.example.northwind.entities.concretes.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1") // version1
public class ShoppingCartsController {

    @Autowired
    IShoppingCartService cartService;

    @DeleteMapping("/carts/{customerId}/{productId}/{quantity}")
    public ShoppingCartItem deleteProductOfTheShoppingCart(@PathVariable(value = "customerId") String customerId, @PathVariable(value = "productId") int productId, @PathVariable(value = "quantity") int quantity) throws Exception {
        return cartService.deleteProductOfTheShoppingCart(customerId, productId, quantity);
    }

   @PutMapping("/carts/{customerId}/{productId}")
   public ShoppingCartItem addProductToTheShoppingCart(@PathVariable String customerId, @PathVariable int productId) throws Exception {
        return cartService.addProductToTheShoppingCart(customerId, productId);
    }

    @GetMapping("/carts/{customerId}")
    public List<ShoppingCartItem> getAllCardItemsOfTheShoppingCartByCustomerId(@PathVariable String customerId){
        return cartService.getAllItemsOfTheShoppingCart(customerId);
    }


}
