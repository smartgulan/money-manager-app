package com.example.money.service;

import com.example.money.dto.UserDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class TokenService {

    public String getEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDto) {
            return ((UserDto) principal).getEmail();
        }
        return null;
    }

    public String getCurrency() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDto) {
            return ((UserDto) principal).getCurrency();
        }
        return null;
    }

}
