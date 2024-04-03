package com.example.server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.Entity.Address;
import com.example.server.Entity.City;
import com.example.server.Entity.District;
import com.example.server.Entity.Wards;

import com.example.server.DTO.AddressDTO;

import com.example.server.Service.AddressService;
import com.example.server.Service.CityService;
import com.example.server.Service.DistrictService;
import com.example.server.Service.WardsService;

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

    
}
