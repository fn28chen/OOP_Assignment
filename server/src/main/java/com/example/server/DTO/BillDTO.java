package com.example.server.DTO;

import lombok.Data;

@Data

public class BillDTO {

    private Long id;
    private Double totalPrice;
    private CartDTO cartDTO;
}
