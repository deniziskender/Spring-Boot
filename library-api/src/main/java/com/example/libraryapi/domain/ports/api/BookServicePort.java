package com.example.libraryapi.domain.ports.api;

import com.example.libraryapi.application.request.CreateBookRequest;
import com.example.libraryapi.application.request.UpdateBookRequest;
import com.example.libraryapi.domain.data.BookDto;

import java.util.List;

public interface BookServicePort {

    BookDto addBook(CreateBookRequest createBookRequest);

    void deleteBookById(Long id);

    BookDto updateBook(UpdateBookRequest updateBookRequest);

    List<BookDto> getBooks();

    BookDto getBookById(Long bookId);
}
