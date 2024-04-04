package com.example.server.Service.Implement;

import com.example.server.Entity.Wards;
import com.example.server.Repository.WardsRepository;
import com.example.server.Service.WardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WardsServiceImpl implements WardsService {
    @Autowired
    WardsRepository wardsRepository;
    @Override
    public ResponseEntity<?> createWards(Wards wards){
        wardsRepository.save(wards);
        return new ResponseEntity<>("Wards created successfully", HttpStatus.CREATED);
    }
    @Override
    public List<Wards> getAllWards(){
        return wardsRepository.getAllWards();
    }

    @Override
    public Wards getById(Long id){
        return wardsRepository.findWardsById(id);
    }
}
