package com.example.shop.Service;

import com.example.shop.Entity.Discount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DiscountService {
    public Discount getById(Long id);

    public ResponseEntity<?> create(Discount discount);

    public ResponseEntity<?> update(Discount discount);

    public ResponseEntity<?> delete(Long id);
}
