package com.example.libraryapi.domain.data;

import com.example.libraryapi.infrastructure.enumtype.Status;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;


@Data
@Builder
public class BookDto {

    private Long id;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    private String title;

    private String description;

    private Double price;

    private Status status;
}