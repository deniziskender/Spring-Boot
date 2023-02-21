package com.example.meapi.domain.service;

import com.example.meapi.application.adapter.api.book.LibraryApiClient;
import com.example.meapi.application.adapter.api.book.response.BooksResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookApiServiceImpl {

    private final LibraryApiClient bookApiClient;

    public BooksResponse getBooks() {
        return bookApiClient.retrieveBooks();
    }
}
