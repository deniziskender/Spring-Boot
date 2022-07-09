package com.example.libraryapi.application.response;

import com.example.libraryapi.domain.data.BookDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BooksResponse {
    private List<BookDto> books;
}
