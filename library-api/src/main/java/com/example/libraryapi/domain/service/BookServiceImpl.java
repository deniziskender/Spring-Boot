package com.example.libraryapi.domain.service;

import com.example.libraryapi.application.request.CreateBookRequest;
import com.example.libraryapi.application.request.UpdateBookRequest;
import com.example.libraryapi.application.response.BookResponse;
import com.example.libraryapi.application.response.BooksPageResponse;
import com.example.libraryapi.application.response.BooksResponse;
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

    @Deprecated
    @Override
    public BooksResponse getBooks() {
        List<BookDto> books = bookPersistencePort.getBooks();
        return BooksResponse.builder().books(books).build();
    }

    @Override
    public BooksPageResponse getBooks(Pageable pageable) {
        BooksDto booksDto = bookPersistencePort.getBooks(pageable);
        return BooksPageResponse.builder().booksDto(booksDto).build();
    }

    @Override
    public BookResponse getBookById(Long bookId) {
        BookDto bookDto = bookPersistencePort.getBookById(bookId);
        return BookResponse.builder().book(bookDto).build();
    }

    @Override
    public BookResponse addBook(CreateBookRequest createBookRequest) {
        BookDto bookDto = bookPersistencePort.addBook(createBookRequest.toModel());
        return BookResponse.builder().book(bookDto).build();
    }

    @Override
    public BookResponse updateBook(Long id, UpdateBookRequest updateBookRequest) {
        BookDto bookDto = bookPersistencePort.updateBook(id, updateBookRequest.toModel());
        return BookResponse.builder().book(bookDto).build();
    }

    @Override
    public void deleteBookById(Long id) {
        bookPersistencePort.deleteBookById(id);
    }
}
