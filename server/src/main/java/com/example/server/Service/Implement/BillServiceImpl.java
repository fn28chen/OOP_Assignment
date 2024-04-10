package com.example.server.Service.Implement;

import com.example.server.Entity.Bill;
import com.example.server.Repository.BillRepository;
import com.example.server.Service.BillService;
import com.example.server.Service.CartItemService;
import com.example.server.Service.CartService;
import com.example.server.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {


    @Autowired
    BillRepository billRepository;

    @Autowired
    CartItemService cartItemService;

    @Autowired
    CartService  cartService;

    @Autowired
    ItemService itemService;

    @Override
    public ResponseEntity<?> create(Bill bill){
        billRepository.save(bill);

        cartService.getAllIdItemInCart(bill.getCart().getId());
        cartItemService.updateStatus(bill.getCart().getId());
        return new ResponseEntity<>("create Bill success", HttpStatus.CREATED);
    }
}
