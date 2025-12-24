package com.springsecurity.learningspringsecurity.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = repository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // var userObj = user.get();

        // return User.builder()
        //         .username(userObj.getUsername())
        //         .password(userObj.getPassword())
        //         .roles(userObj.getRole())   // ROLE_ADMIN / ROLE_USER without ROLE_ prefix
        //         .build();

        User userObj = user.get();

        return org.springframework.security.core.userdetails.User
                .withUsername(userObj.getUsername())
                .password(userObj.getPassword())
                .roles(userObj.getRole())   // ROLE_ADMIN / ROLE_USER without ROLE_ prefix
                .build();
    }
}
