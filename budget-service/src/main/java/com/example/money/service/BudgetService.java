package com.example.money.service;

import com.example.common.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {

    public ResponseEntity<?> budget() {
        ErrorMessage error = new ErrorMessage();
        error.setMessage("budget");
        error.setStatus("ok");
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

}
