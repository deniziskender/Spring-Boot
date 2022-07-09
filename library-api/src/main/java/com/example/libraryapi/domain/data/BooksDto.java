package com.example.libraryapi.domain.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BooksDto {
    private List<BookDto> books;
    private boolean hasMore;
    private Integer page;
    private Integer pageSize;
}
