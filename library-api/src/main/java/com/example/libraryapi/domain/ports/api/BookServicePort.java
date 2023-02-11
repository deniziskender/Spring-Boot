package com.example.libraryapi.domain.ports.api;

import com.example.libraryapi.application.request.CreateBookRequest;
import com.example.libraryapi.application.request.UpdateBookRequest;
import com.example.libraryapi.application.response.BookResponse;
import com.example.libraryapi.application.response.BooksPageResponse;
import com.example.libraryapi.application.response.BooksResponse;
import org.springframework.data.domain.Pageable;

public interface BookServicePort {

    BookResponse getBookById(Long bookId);

    BooksResponse getBooks();

    BooksPageResponse getBooks(Pageable pageable);

    BookResponse addBook(CreateBookRequest createBookRequest);

    BookResponse updateBook(Long id, UpdateBookRequest updateBookRequest);

    void deleteBookById(Long id);
}
