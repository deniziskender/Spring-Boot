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

    @NotNull(message = "request.validation.book.id.null")
    private Long id;

    @NotBlank(message = "request.validation.book.title.blank")
    private String title;

    @NotBlank(message = "request.validation.book.description.blank")
    private String description;

    @NotNull(message = "request.validation.book.price.null")
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
