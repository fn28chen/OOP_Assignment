package com.example.server.Service.Implement;

import com.example.server.Entity.Discount;
import com.example.server.Repository.DiscountRepository;
import com.example.server.Service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    DiscountRepository discountRepository;

    @Override
    public Discount getById(Long id) {
        return discountRepository.getDiscountById(id);
    }

    @Override
    public ResponseEntity<?> create(Discount discount) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(Discount discount) {
        Discount discount1 = discountRepository.getDiscountById(discount.getId());
        discount1.setPercent(discount.getPercent());
        return new ResponseEntity<>("Up date discount success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        discountRepository.deleteById(id);
        return new ResponseEntity<>("Delete discount success", HttpStatus.OK);
    }

}
