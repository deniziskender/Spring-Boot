package com.example.meapi.application.adapter.api.book;

import com.example.meapi.application.adapter.api.book.response.BooksResponse;
import com.example.meapi.application.adapter.api.book.response.dto.BookDto;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@ConditionalOnProperty(value = "mock.library.api.service.enabled", havingValue = "true")
public class MockRestBookApiClient implements BookApiClient {

    @Override
    public BooksResponse retrieveBooks() {
        return BooksResponse.builder()
                .books(getBooks())
                .build();
    }

    private List<BookDto> getBooks() {
        return Arrays.asList(BookDto.builder().build(),
                BookDto.builder().build());
    }
}
