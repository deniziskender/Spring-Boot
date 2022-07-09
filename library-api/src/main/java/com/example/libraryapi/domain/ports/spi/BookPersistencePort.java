package com.example.libraryapi.domain.ports.spi;

import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.domain.data.CreateBookVo;
import com.example.libraryapi.domain.data.UpdateBookVo;

import java.util.List;

public interface BookPersistencePort {

    BookDto addBook(CreateBookVo bookVo);

    void deleteBookById(Long id);

    BookDto updateBook(UpdateBookVo updateBookVo);

    List<BookDto> getBooks();

    BookDto getBookById(Long bookId);

}
