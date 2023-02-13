package com.example.meapi.application.adapter.api.book.response;

import com.example.meapi.application.adapter.api.book.response.dto.BookDto;
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

