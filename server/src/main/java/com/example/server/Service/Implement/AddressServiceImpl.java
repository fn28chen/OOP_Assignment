package com.example.server.Service.Implement;

import com.example.server.Entity.Address;
import com.example.server.Repository.AddressRepository;
import com.example.server.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Override
    public ResponseEntity<?> createAddress(Address address){
        addressRepository.save(address);
        return new ResponseEntity<>("Address create Success", HttpStatus.CREATED);
    }
}
