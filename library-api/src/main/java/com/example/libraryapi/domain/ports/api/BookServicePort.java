package com.example.libraryapi.domain.ports.api;

import com.example.libraryapi.application.request.CreateBookRequest;
import com.example.libraryapi.application.request.UpdateBookRequest;
import com.example.libraryapi.application.response.BookResponse;
import com.example.libraryapi.application.response.BooksPageResponse;
import com.example.libraryapi.application.response.BooksResponse;
import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.domain.data.BooksDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookServicePort {

    BookResponse addBook(CreateBookRequest createBookRequest);

    void deleteBookById(Long id);

    BookResponse updateBook(UpdateBookRequest updateBookRequest);

    BooksResponse getBooks();

    BooksPageResponse getBooks(Pageable pageable);

    BookResponse getBookById(Long bookId);
}
