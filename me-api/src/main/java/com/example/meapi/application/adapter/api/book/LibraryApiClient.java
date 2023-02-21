package com.example.meapi.application.adapter.api.book;

import com.example.meapi.application.adapter.api.book.response.BooksResponse;

public interface LibraryApiClient {

    BooksResponse retrieveBooks();
}
