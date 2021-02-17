package com.example.northwind.entities.concretes;

import com.example.northwind.entities.abstracts.IEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shopping_carts_items")
public class ShoppingCartItem implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "quantity")
    private int quantity;
}
