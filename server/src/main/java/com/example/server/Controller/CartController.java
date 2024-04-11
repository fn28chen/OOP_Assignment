package com.example.server.Controller;

import com.example.server.DTO.CartDTO;
import com.example.server.DTO.ItemDTO;
import com.example.server.Entity.Cart;
import com.example.server.Entity.Item;
import com.example.server.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/add/items")
    public ResponseEntity<?> addItemWithCart(@RequestBody CartDTO cartDTO) {
        return cartService.addItemWithCart(mapperCart(cartDTO));
    }

    @PostMapping("/buy/all/{idCart}")
    public ResponseEntity<?> buyAll(@PathVariable Long idCart){
        return cartService.buyAllItem(idCart);
    }

    private Cart mapperCart(CartDTO cartDTO) {
        Cart cart = new Cart();
        cart.setId(cartDTO.getId());
        List<Item> items = new ArrayList<>();
        for (ItemDTO itemDTO : cartDTO.getItemDTOS()) {
            Item item = new Item();
            item.setId(itemDTO.getId());
            item.setCount(itemDTO.getCount());
            items.add(item);
        }
        cart.setItems(items);
        return cart;
    }
}
