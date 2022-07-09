package com.example.libraryapi.infrastructure.enumtype;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Status {
    PASSIVE(0),
    ACTIVE(1);

    private final Integer value;

    public static Status fromValue(Integer value) {
        return Arrays.stream(values())
                .filter(status -> status.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}
