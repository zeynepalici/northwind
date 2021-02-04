package com.example.northwind.entities.concretes;

import com.example.northwind.entities.abstracts.IEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class Category implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "description")
    private String description;
    @Column(name = "picture")
    private byte[] picture;
}
