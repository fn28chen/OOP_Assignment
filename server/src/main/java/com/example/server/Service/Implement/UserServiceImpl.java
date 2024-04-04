package com.example.server.Service.Implement;

import com.example.server.Entity.Cart;
import com.example.server.Entity.User;
import com.example.server.Repository.UserRepository;
import com.example.server.Service.CartService;
import com.example.server.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

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
}
