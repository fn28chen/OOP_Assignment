package com.example.server.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Double price;
    private String color;
    private String size;
    private Long count;

    @ManyToOne
    private Category category;
    @ManyToOne
    private Discount discount;
    @ManyToOne
    private DescriptionItem descriptionItem;
//    @ManyToMany(mappedBy ="items")
//    private List<Size> size;

}
