package com.example.money.service;

import com.example.money.config.JwtTokenUtil;
import com.example.money.model.User;
import com.example.money.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists");
        }
        user.setCreated_at(new Date());
        return userRepository.save(user);
    }

    public String login(User user) {
        User userExists = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (userExists == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
        }
        if (!user.getPassword().equals(userExists.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password");
        }
        return jwtTokenUtil.doGenerateToken(userExists);
    }

}
