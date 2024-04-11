package com.example.server.Service.Implement;

import com.example.server.Entity.*;
import com.example.server.Repository.CartRepository;
import com.example.server.Service.CartItemService;
import com.example.server.Service.CartService;
import com.example.server.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemService cartItemService;

    @Autowired
    ItemService itemService;

    @Override
    public ResponseEntity<?> create(Cart cart) {
        cartRepository.save(cart);
        return new ResponseEntity<>("Create Cart success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> addItemWithCart(Cart cart) {
        Cart cart1 = cartRepository.findCartById(cart.getId());
        if (cart1 != null) {
//            cart1.setItems(cart.getItems());
        } else {
            return new ResponseEntity<>("data error", HttpStatus.NOT_ACCEPTABLE);
        }
        for (Item items : cart.getItems()) {
            CartItem cartItem = new CartItem();

            cartItem.setCount(items.getCount());
            Item item = itemService.getById(items.getId());
            cartItem.setCart(cart1);
            cartItem.setItem(item);
            cartItemService.create(cartItem);
        }
        return new ResponseEntity<>("add Items success: ", HttpStatus.OK);
    }


//    @Override
//    public Double total(Long id){
//        Double total = 0D;
//        List<Long> idItems  = cartItemService.getFullIdItem(id);
//        for (Long idItem : idItems){
//            Item item = itemService.getById(idItem);
//            Long count  = cartItemService.getCount(id, item.getId());
//            total += item.getPrice()*count;
//        }
//        return total;
//    }


    @Override
    public ResponseEntity<?> buyAllItem(Long idCart) {
        cartItemService.buyAll(idCart);
        return new ResponseEntity<>("Accept all", HttpStatus.ACCEPTED);
    }

    @Override
    public Cart getById(Long idCart){
        Cart cart = cartRepository.findCartById(idCart);
        return cart;
    }
//todo bug
    @Override
    public List<Pair> getAllIdItemInCart(Long id){
        List<NewPair>  newPairs = cartRepository.getAllIdItemInCart(id);
        List<Pair> pairs = new ArrayList<>();
        for(NewPair pair : newPairs){
            Pair pair1 = new Pair();
            System.out.println(pair.getId());
//            System.out.println(pair.h);
//            System.out.println(pair.getALL().getId());
            //loi doan nay ko lay duoc id
            pair1.setId(pair.getId());
            pair1.setCount(pair.getCount());
            pairs.add(pair1);
        }
        itemService.updateCount(pairs);
        return pairs;
    }
}
