package com.example.server.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DiscountDTO {
    private Long id;
    private long percent;

    public DiscountDTO(Long id, long percent) {
        this.id = id;
        this.percent = percent;
    }

}
