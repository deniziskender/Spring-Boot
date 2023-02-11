package com.example.libraryapi.application.request;

import com.example.libraryapi.domain.data.UpdateBookVo;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
public class UpdateBookRequest {
    @NotBlank(message = "request.validation.book.title.blank")
    private String title;

    @NotBlank(message = "request.validation.book.description.blank")
    private String description;

    @NotNull(message = "request.validation.book.price.null")
    private Double price;


    public UpdateBookVo toModel() {
        return UpdateBookVo.builder()
                .title(this.title)
                .description(this.description)
                .price(this.price)
                .build();
    }
}
