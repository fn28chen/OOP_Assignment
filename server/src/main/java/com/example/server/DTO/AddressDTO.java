package com.example.shop.DTO;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String description;
    private CityDTO cityDTO;
    private WardsDTO wardsDTO;
    private DistrictDTO districtDTO;
}
