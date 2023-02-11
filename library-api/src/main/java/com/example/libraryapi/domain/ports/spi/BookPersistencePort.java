package com.example.libraryapi.domain.ports.spi;

import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.domain.data.BooksDto;
import com.example.libraryapi.domain.data.CreateBookVo;
import com.example.libraryapi.domain.data.UpdateBookVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookPersistencePort {

    List<BookDto> getBooks();

    BooksDto getBooks(Pageable pageable);

    BookDto getBookById(Long bookId);

    BookDto addBook(CreateBookVo bookVo);

    BookDto updateBook(Long id, UpdateBookVo updateBookVo);

    void deleteBookById(Long id);
}
