package com.example.server.DTO;

import lombok.Data;

@Data
public class ItemDTO {

    private Long id;
    private String name;
    private String image;
    private Double price;
    private String color;
    private String size;
    private long count;

    private CategoryDTO categoryDTO;
    private DiscountDTO discountDTO;
    private DescriptionItemDTO descriptionItemDTO;
}
