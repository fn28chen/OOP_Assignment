package com.example.server.Service;

import com.example.server.Entity.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public interface BillService {
    public ResponseEntity<?> create(Bill bill);
}
