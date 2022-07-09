package com.example.libraryapi.domain.ports.spi;

import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.domain.data.BooksDto;
import com.example.libraryapi.domain.data.CreateBookVo;
import com.example.libraryapi.domain.data.UpdateBookVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookPersistencePort {

    BookDto addBook(CreateBookVo bookVo);

    void deleteBookById(Long id);

    BookDto updateBook(UpdateBookVo updateBookVo);

    List<BookDto> getBooks();

    BooksDto getBooks(Pageable pageable);

    BookDto getBookById(Long bookId);

}
