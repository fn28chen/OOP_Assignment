package com.example.server.Service.Implement;

import com.example.server.Entity.Cart;
import com.example.server.Entity.Item;
import com.example.server.Entity.User;
import com.example.server.Repository.CartItemRepository;
import com.example.server.Repository.ItemRepository;
import com.example.server.Repository.UserRepository;
import com.example.server.Service.CartService;
import com.example.server.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // implement interface ( inheritance )
    // logic for userService
    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartService cartService;
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return user;
    }

    @Override
    public void createUser(User user){
        User userCheck = userRepository.findByEmail(user.getEmail());
        if(userCheck != null)
        {
            throw new RuntimeException("Tai khoan da ton tai");
        }
        User user1 = userRepository.save(user);
        Cart cart = new Cart();
        cart.setUser(user1);
        cartService.create(cart);
    }

    @Override
    public List<Item> getAllItem(User user){
        List<Item> items = itemRepository.getAllItem(user.getId());
        return items;
    }
    
    @Override
    public User getUserByEmail(String email) {
        User user = userRepository.loadByUserName(email);
        return user;
    }
}