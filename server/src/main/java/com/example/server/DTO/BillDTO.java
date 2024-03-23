package com.example.shop.DTO;

import lombok.Data;

@Data

public class BillDTO {

    private Long id;
    private Double totalPrice;
    private CartDTO cartDTO;
}
