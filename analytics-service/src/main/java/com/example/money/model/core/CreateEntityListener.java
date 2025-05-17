package com.example.money.model.core;

import javax.persistence.PrePersist;
import java.util.Date;

public class CreateEntityListener {

    @PrePersist
    public void setCreatedAt(CreateEntity entity) {
        entity.setCreated_at(new Date());
    }

}
