package com.example.server.Service.Implement;

import com.example.server.Entity.Bill;
import com.example.server.Repository.BillRepository;
import com.example.server.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {


    @Autowired
    BillRepository billRepository;


    @Override
    public ResponseEntity<?> create(Bill bill){
        billRepository.save(bill);
        return new ResponseEntity<>("create Bill success", HttpStatus.CREATED);
    }
}
