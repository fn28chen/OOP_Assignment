package com.example.server.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private long count;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Item item;
}
