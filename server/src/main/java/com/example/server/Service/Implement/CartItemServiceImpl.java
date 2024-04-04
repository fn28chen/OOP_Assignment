package com.example.server.Service.Implement;

import com.example.server.Entity.CartItem;
import com.example.server.Repository.CartItemRepository;
import com.example.server.Service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {


    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public void create(CartItem item){
        item.setStatus("FALSE");
        cartItemRepository.save(item);
    }

    @Override
    public void updateStatus(Long idCart){
        List<CartItem> items = cartItemRepository.getCartItemsByIdCart(idCart);
        for (CartItem item : items){
            item.setStatus("FALSE");
            cartItemRepository.save(item);
        }
    }

    @Override
    public List<Long> getFullIdItem(Long idCart){
        List<Long> idItems = cartItemRepository.getFullIdItem(idCart);
        return idItems;
    }

    @Override
    public Long getCount(Long idCart, Long idItem){
        return cartItemRepository.getCount(idCart, idItem);
    }

    @Override
    public void buyAll(Long idCart){
        List<CartItem> items = cartItemRepository.getCartItemsByIdCart(idCart);
        for (CartItem item : items){
            item.setStatus("TRUE");
            cartItemRepository.save(item);
        }
    }
}
