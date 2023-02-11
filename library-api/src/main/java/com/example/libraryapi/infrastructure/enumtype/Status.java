package com.example.libraryapi.infrastructure.enumtype;

import com.example.libraryapi.infrastructure.exception.BookApiBusinessException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Status {
    PASSIVE(0),
    ACTIVE(1);

    private static final String BOOK_STATUS_NOT_FOUND = "book.status.not.found";

    private final Integer value;

    public static Status fromValue(Integer value) {
        return Arrays.stream(values())
                .filter(status -> status.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new BookApiBusinessException(BOOK_STATUS_NOT_FOUND));
    }
}
