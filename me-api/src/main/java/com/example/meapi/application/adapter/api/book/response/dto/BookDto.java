package com.example.meapi.application.adapter.api.book.response.dto;

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
}