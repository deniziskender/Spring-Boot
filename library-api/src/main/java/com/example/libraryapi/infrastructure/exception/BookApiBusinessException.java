package com.example.libraryapi.infrastructure.exception;

import lombok.Getter;

@Getter
public class BookApiBusinessException extends RuntimeException {

    public BookApiBusinessException() {
        super();
    }
}