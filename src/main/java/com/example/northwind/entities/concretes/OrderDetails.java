package com.example.northwind.entities.concretes;


import com.example.northwind.entities.abstracts.IEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_details")
@IdClass(CompositeKey.class)
public class OrderDetails implements IEntity {
    @Id
    @Column(name = "order_id")
    private int orderId;
    @Id
    @Column(name = "product_id")
    private int productId;
    @Column(name = "quantity")
    private int quantity;

}
