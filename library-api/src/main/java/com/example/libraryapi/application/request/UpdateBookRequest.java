package com.example.libraryapi.application.request;

import com.example.libraryapi.domain.data.UpdateBookVo;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBookRequest {

    @NotNull
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Double price;


    public UpdateBookVo toModel() {
        return UpdateBookVo.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .price(this.price)
                .build();
    }
}
