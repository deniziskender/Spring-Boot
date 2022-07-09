package com.example.libraryapi.application.response;

import com.example.libraryapi.domain.data.BooksDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BooksPageResponse {
    private BooksDto booksDto;
}
