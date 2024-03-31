package com.example.server.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalPrice;
    @ManyToOne
    private Cart cart;
}
