package com.example.libraryapi.domain.data;

import lombok.*;

@Builder
@Getter
public class CreateBookVo {
    private String title;

    private String description;

    private Double price;
}
