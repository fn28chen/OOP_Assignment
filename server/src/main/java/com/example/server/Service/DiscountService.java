package com.example.server.Service;

import com.example.server.Entity.Discount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DiscountService {
    public Discount getById(Long id);

    public ResponseEntity<?> create(Discount discount);

    public ResponseEntity<?> update(Discount discount);

    public ResponseEntity<?> delete(Long id);
}
