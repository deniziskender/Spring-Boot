package com.example.libraryapi.domain.data;

import com.example.libraryapi.infrastructure.enumtype.Status;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class BookDto {

    private Long id;

    private String title;

    private String description;

    private Double price;

    private Status status;
}