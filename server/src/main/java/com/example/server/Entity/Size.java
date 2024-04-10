package com.example.server.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sizeItem;

    @ManyToMany
    @JoinTable(name="sizeItem",joinColumns = @JoinColumn(name = "size_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;
}
