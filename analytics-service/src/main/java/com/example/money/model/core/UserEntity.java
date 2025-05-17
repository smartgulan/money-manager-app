package com.example.money.model.core;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(UserEntityListener.class)
public abstract class UserEntity extends CreateEntity {

    @Column
    private String createdBy;

    public String getUserEmail() {
        return createdBy;
    }

    public void setUserEmail(String createdBy) {
        this.createdBy = createdBy;
    }

}
