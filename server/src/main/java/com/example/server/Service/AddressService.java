package com.example.server.Service;

import com.example.server.Entity.Address;
import org.springframework.http.ResponseEntity;

public interface AddressService {
    public ResponseEntity<?> createAddress(Address address);

}
