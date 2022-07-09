package com.example.libraryapi.application.request;

import com.example.libraryapi.domain.data.CreateBookVo;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Double price;


    public CreateBookVo toModel() {
        return CreateBookVo.builder()
                .title(this.title)
                .description(this.description)
                .price(this.price)
                .build();
    }
}
