package com.example.money.service;

import com.example.money.config.SpringSecurityUser;
import com.example.money.model.User;
import com.example.money.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(email);
        }
        return new SpringSecurityUser(user.get());
    }

}
