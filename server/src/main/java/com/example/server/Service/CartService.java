package com.example.server.Service;

import com.example.server.Entity.Cart;
import com.example.server.Entity.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    public ResponseEntity<?> create(Cart cart);
    public ResponseEntity<?> addItemWithCart(Cart cart);
    public ResponseEntity<?> buyAllItem(Long id);

    public Cart getById(Long idCart);
}
