package com.example.server.Service;

import com.example.server.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public void createUser(User user);
}
