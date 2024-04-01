package com.example.server.Controller;

import com.example.server.DTO.BillDTO;
import com.example.server.Entity.Bill;
import com.example.server.Entity.Cart;
import com.example.server.Service.BillService;
import com.example.server.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    BillService billService;

    @Autowired
    CartService cartService;
    @PostMapping("/create/bill")
    public ResponseEntity<?> create(@RequestBody BillDTO billDTO){
        return billService.create(mapper(billDTO));
    }

    private Bill mapper(BillDTO billDTO){
        Bill bill = new Bill();
        bill.setId(billDTO.getId());
        bill.setTotalPrice(billDTO.getTotalPrice());
        Cart cart = cartService.getById(billDTO.getCartDTO().getId());
        bill.setCart(cart);
        return bill;
    }
}
