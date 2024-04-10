package com.example.server.Controller;

import com.example.server.Common.MapAddress;
import com.example.server.DTO.AddressDTO;
import com.example.server.Entity.Address;
import com.example.server.Entity.City;
import com.example.server.Entity.District;
import com.example.server.Entity.Wards;
import com.example.server.Service.AddressService;
import com.example.server.Service.CityService;
import com.example.server.Service.DistrictService;
import com.example.server.Service.WardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @Autowired
    CityService cityService;

    @Autowired
    WardsService wardsService;

    @Autowired
    DistrictService districtService;

    @PostMapping("/create")
    public ResponseEntity<?> createAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.createAddress(mapAddress(addressDTO));
    }
    private Address mapAddress(AddressDTO addressDTO){
        Address address = new Address();

        Wards wards = wardsService.getById(addressDTO.getWardsDTO().getId());
        District district = districtService.getById(addressDTO.getDistrictDTO().getId());
        City city = cityService.getById(addressDTO.getCityDTO().getId());

        address.setId(addressDTO.getId());
        address.setDescription(addressDTO.getDescription());
        address.setDistrict(district);
        address.setWards(wards);
        address.setCity(city);

        return address;
    }
}
