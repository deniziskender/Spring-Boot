package com.example.meapi.domain.data;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;


@Data
@Builder
public class MeDto {

    private Long id;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    private String title;

    private String description;

    private Double price;
}