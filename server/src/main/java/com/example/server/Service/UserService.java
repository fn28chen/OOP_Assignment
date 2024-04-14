package com.example.server.Service;

import com.example.server.Entity.Item;
import com.example.server.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // abstraction
    // public methods
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public void createUser(User user);

    public List<Item> getAllItem(User  user);

    public User getUserByEmail(String email);
    
}