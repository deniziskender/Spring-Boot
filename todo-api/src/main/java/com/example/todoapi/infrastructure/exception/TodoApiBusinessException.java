package com.example.todoapi.infrastructure.exception;

import lombok.Getter;

@Getter
public class TodoApiBusinessException extends RuntimeException {

    public TodoApiBusinessException(String message) {
        super(message);
    }
}