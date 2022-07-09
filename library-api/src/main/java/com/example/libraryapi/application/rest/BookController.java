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
@RequestMapping("/book")
public class BookController {

    private final BookServicePort bookServicePort;

    @PostMapping("/add")
    public BookResponse addBook(@RequestBody @Valid CreateBookRequest createBookRequest) {
        BookDto bookDto = bookServicePort.addBook(createBookRequest);
        return BookResponse.builder().book(bookDto).build();
    }

    @PutMapping("/update")
    public BookResponse updateBook(@RequestBody @Valid UpdateBookRequest updateBookRequest) {
        BookDto bookDto = bookServicePort.updateBook(updateBookRequest);
        return BookResponse.builder().book(bookDto).build();
    }

    @GetMapping("/get/{id}")
    public BookResponse getBookByID(@PathVariable long id) {
        BookDto bookDto = bookServicePort.getBookById(id);
        return BookResponse.builder().book(bookDto).build();
    }

    @Deprecated
    @GetMapping("/get")
    public BooksResponse getAllBooks() {
        List<BookDto> books = bookServicePort.getBooks();
        return BooksResponse.builder().books(books).build();
    }

    @GetMapping("/get/slice")
    public BooksPageResponse getAllBooks(Pageable pageable) {
        BooksDto booksDto = bookServicePort.getBooks(pageable);
        return BooksPageResponse.builder().booksDto(booksDto).build();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteBookByID(@PathVariable long id) {
        bookServicePort.deleteBookById(id);
    }
}
