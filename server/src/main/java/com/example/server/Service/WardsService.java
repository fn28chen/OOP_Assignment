package com.example.server.Service;

import com.example.server.Entity.City;
import com.example.server.Entity.Wards;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface WardsService {

    public ResponseEntity<?> createWards(Wards wards);
}
