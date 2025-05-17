package com.example.money.model.core;

import com.example.money.dto.UserDto;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.PrePersist;

public class UserEntityListener {

    @PrePersist
    public void setUserInfo(UserEntity entity) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDto) {
            UserDto user = (UserDto) principal;
            entity.setUserEmail(user.getEmail());
            entity.setCurrency(user.getCurrency());
        }
    }

}
