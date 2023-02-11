package com.example.libraryapi.domain.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BooksDto {
    private List<BookDto> books;
    private boolean hasMore;
    private Integer pageNumber;
    private Integer totalPages;
}
