package com.example.libraryapi.domain.service;

import com.example.libraryapi.application.request.CreateBookRequest;
import com.example.libraryapi.application.request.UpdateBookRequest;
import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.domain.data.BooksDto;
import com.example.libraryapi.domain.ports.api.BookServicePort;
import com.example.libraryapi.domain.ports.spi.BookPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookServicePort {

    private final BookPersistencePort bookPersistencePort;

    @Override
    public BookDto addBook(CreateBookRequest createBookRequest) {
        return bookPersistencePort.addBook(createBookRequest.toModel());
    }

    @Override
    public void deleteBookById(Long id) {
        bookPersistencePort.deleteBookById(id);
    }

    @Override
    public BookDto updateBook(UpdateBookRequest updateBookRequest) {
        return bookPersistencePort.updateBook(updateBookRequest.toModel());
    }

    @Deprecated
    @Override
    public List<BookDto> getBooks() {
        return bookPersistencePort.getBooks();
    }

    @Override
    public BooksDto getBooks(Pageable pageable) {
        return bookPersistencePort.getBooks(pageable);
    }

    @Override
    public BookDto getBookById(Long bookId) {
        return bookPersistencePort.getBookById(bookId);
    }
}
