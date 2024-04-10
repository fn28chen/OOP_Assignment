package com.example.server.DTO;

import lombok.Data;

@Data
public class DescriptionItemDTO {
    private Long id;
    private String material;
    private String form;
    private String description;

    public DescriptionItemDTO(Long id, String material, String form, String description) {
        this.id = id;
        this.material = material;
        this.form = form;
        this.description = description;
    }
}
