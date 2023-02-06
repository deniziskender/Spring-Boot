package com.example.libraryapi.application.rest;

import com.example.libraryapi.application.request.CreateBookRequest;
import com.example.libraryapi.application.request.UpdateBookRequest;
import com.example.libraryapi.application.response.BookResponse;
import com.example.libraryapi.application.response.BooksPageResponse;
import com.example.libraryapi.application.response.BooksResponse;
import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.domain.data.BooksDto;
import com.example.libraryapi.domain.ports.api.BookServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookServicePort bookServicePort;

    @PostMapping("/v1/books/add")
    public BookResponse addBook(@RequestBody @Valid CreateBookRequest createBookRequest) {
        return bookServicePort.addBook(createBookRequest);
    }

    @PutMapping("/v1/books/update")
    public BookResponse updateBook(@RequestBody @Valid UpdateBookRequest updateBookRequest) {
        return bookServicePort.updateBook(updateBookRequest);
    }

    @GetMapping("/v1/books/{id}")
    public BookResponse getBookByID(@PathVariable long id) {
        return bookServicePort.getBookById(id);
    }

    @Deprecated
    @GetMapping("/v1/books")
    public BooksResponse getAllBooks() {
        return bookServicePort.getBooks();
    }

    @GetMapping("/v1/books/slice")
    public BooksPageResponse getAllBooks(Pageable pageable) {
        return bookServicePort.getBooks(pageable);
    }

    @DeleteMapping("/v1/books/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteBookByID(@PathVariable long id) {
        bookServicePort.deleteBookById(id);
    }
}
