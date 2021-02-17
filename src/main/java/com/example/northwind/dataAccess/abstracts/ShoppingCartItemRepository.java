package com.example.northwind.dataAccess.abstracts;

import com.example.northwind.entities.concretes.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem,Integer> {

    ShoppingCartItem getById(Integer Id);


    ShoppingCartItem findByCartIdAndProductId(Integer cartId, Integer productId);

    List<ShoppingCartItem> getAllByCartId(int cartId);
    boolean existsShoppingCartItemByCartIdAndProductIdAndQuantityGreaterThan(Integer cartId, Integer productId, Integer quantity);
    boolean existsShoppingCartItemByCartIdAndProductIdAndQuantityEquals(Integer cartId, Integer productId, Integer quantity);

    boolean existsShoppingCartItemByCartIdAndProductId(Integer cartId, Integer productId);


}
