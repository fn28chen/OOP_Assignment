package com.example.server.Service;

import com.example.server.Entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartItemService {

    public void updateStatus(Long idCart);

    public List<Long> getFullIdItem(Long idCart);

    public Long getCount(Long idCart, Long idItem);
    public void buyAll(Long idCart);
    public void create(CartItem item);
}
