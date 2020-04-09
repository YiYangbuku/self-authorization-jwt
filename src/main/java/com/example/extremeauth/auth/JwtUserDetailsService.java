package com.example.extremeauth.auth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JwtUserDetailsService {
    public UserDetails loadUserByUsername(String username) {
        return new User(username, "pass", Collections.singletonList(new SimpleGrantedAuthority("admin")));
    }
}
