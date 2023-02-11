package com.example.libraryapi.application.request;

import com.example.libraryapi.domain.data.CreateBookVo;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
public class CreateBookRequest {

    @NotBlank(message = "request.validation.book.title.blank")
    private String title;

    @NotBlank(message = "request.validation.book.description.blank")
    private String description;

    @NotNull(message = "request.validation.book.price.null")
    private Double price;


    public CreateBookVo toModel() {
        return CreateBookVo.builder().title(this.title).description(this.description).price(this.price).build();
    }
}
