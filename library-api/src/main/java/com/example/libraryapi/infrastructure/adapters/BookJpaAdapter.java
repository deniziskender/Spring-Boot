package com.example.libraryapi.infrastructure.adapters;

import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.domain.data.BooksDto;
import com.example.libraryapi.domain.data.CreateBookVo;
import com.example.libraryapi.domain.data.UpdateBookVo;
import com.example.libraryapi.domain.ports.spi.BookPersistencePort;
import com.example.libraryapi.infrastructure.entity.Book;
import com.example.libraryapi.infrastructure.enumtype.Status;
import com.example.libraryapi.infrastructure.exception.BookApiBusinessException;
import com.example.libraryapi.infrastructure.mappers.BookMapper;
import com.example.libraryapi.infrastructure.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookJpaAdapter implements BookPersistencePort {

    private final BookRepository bookRepository;

    @Override
    public BookDto addBook(CreateBookVo createBookVo) {
        Book book = new Book();
        book.setTitle(createBookVo.getTitle());
        book.setDescription(createBookVo.getDescription());
        book.setPrice(createBookVo.getPrice());
        book.setStatus(Status.ACTIVE);

        Book savedBook = bookRepository.save(book);
        return BookMapper.INSTANCE.bookToBookDto(savedBook);
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = bookRepository.findByIdAndStatus(id, Status.ACTIVE)
                .orElseThrow(BookApiBusinessException::new);

        book.setStatus(Status.PASSIVE);
        bookRepository.save(book);
    }

    @Override
    public BookDto updateBook(UpdateBookVo updateBookVo) {
        Book book = bookRepository.findByIdAndStatus(updateBookVo.getId(), Status.ACTIVE)
                .orElseThrow(BookApiBusinessException::new);

        book.setTitle(updateBookVo.getTitle());
        book.setPrice(updateBookVo.getPrice());
        book.setDescription(updateBookVo.getDescription());
        Book savedBook = bookRepository.save(book);

        return BookMapper.INSTANCE.bookToBookDto(savedBook);
    }

    @Deprecated
    @Override
    public List<BookDto> getBooks() {
        List<Book> bookList = bookRepository.findByStatus(Status.ACTIVE);
        return BookMapper.INSTANCE.bookListToBookDtoList(bookList);
    }

    @Override
    public BooksDto getBooks(Pageable pageable) {
        Page<Book> bookPage = bookRepository.findAll(pageable);
        List<BookDto> books = BookMapper.INSTANCE.bookListToBookDtoList(bookPage.getContent());
        return BooksDto.builder()
                .books(books)
                .hasMore(bookPage.hasNext())
                .page(bookPage.getNumber())
                .pageSize(bookPage.getTotalPages())
                .build();
    }

    @Override
    public BookDto getBookById(Long bookId) {
        Book book = bookRepository.findByIdAndStatus(bookId, Status.ACTIVE)
                .orElseThrow(BookApiBusinessException::new);
        return BookMapper.INSTANCE.bookToBookDto(book);
    }
}
