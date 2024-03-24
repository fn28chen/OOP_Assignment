package com.example.server.Service;

import com.example.server.Entity.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    public ResponseEntity<?> create(Item item);

    public Item getById(Long idItem);
    public List<Item> getAllItemInCart(Long idCart);

    public List<Item> getAllItemWithCategory(Long idCategory);
    public List<Item> getAll();
}
