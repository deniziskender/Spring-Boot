package com.example.libraryapi.infrastructure.adapters;

import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.domain.data.BooksDto;
import com.example.libraryapi.domain.data.CreateBookVo;
import com.example.libraryapi.domain.data.UpdateBookVo;
import com.example.libraryapi.domain.ports.spi.BookPersistencePort;
import com.example.libraryapi.infrastructure.enumtype.Status;
import com.example.libraryapi.infrastructure.exception.BookApiBusinessException;
import com.example.libraryapi.infrastructure.repository.BookRepository;
import com.example.libraryapi.infrastructure.entity.BookEntity;
import com.example.libraryapi.infrastructure.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookJpaAdapter implements BookPersistencePort {

    private static final String ADAPTER_VALIDATION_BOOK_NOT_FOUND = "adapter.validation.book.not.found";

    private final BookRepository bookRepository;

    @Deprecated
    @Override
    public List<BookDto> getBooks() {
        List<BookEntity> bookEntityList = bookRepository.findByStatus(Status.ACTIVE);
        return BookMapper.INSTANCE.bookListToBookDtoList(bookEntityList);
    }

    @Override
    public BooksDto getBooks(Pageable pageable) {
        Page<BookEntity> bookPage = bookRepository.findByStatus(Status.ACTIVE, pageable);
        List<BookDto> books = BookMapper.INSTANCE.bookListToBookDtoList(bookPage.getContent());
        return BooksDto.builder()
                .books(books)
                .hasMore(bookPage.hasNext())
                .pageNumber(bookPage.getNumber())
                .totalPages(bookPage.getTotalPages())
                .build();
    }

    @Override
    public BookDto getBookById(Long bookId) {
        BookEntity bookEntity = bookRepository.findByIdAndStatus(bookId, Status.ACTIVE)
                .orElseThrow(() -> new BookApiBusinessException(ADAPTER_VALIDATION_BOOK_NOT_FOUND));
        return BookMapper.INSTANCE.bookToBookDto(bookEntity);
    }

    @Override
    public BookDto addBook(CreateBookVo createBookVo) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(createBookVo.getTitle());
        bookEntity.setDescription(createBookVo.getDescription());
        bookEntity.setPrice(createBookVo.getPrice());
        bookEntity.setStatus(Status.ACTIVE);

        BookEntity savedBookEntity = bookRepository.save(bookEntity);
        return BookMapper.INSTANCE.bookToBookDto(savedBookEntity);
    }

    @Override
    public BookDto updateBook(Long id, UpdateBookVo updateBookVo) {
        BookEntity bookEntity = bookRepository.findByIdAndStatus(id, Status.ACTIVE)
                .orElseThrow(() -> new BookApiBusinessException(ADAPTER_VALIDATION_BOOK_NOT_FOUND));

        bookEntity.setTitle(updateBookVo.getTitle());
        bookEntity.setPrice(updateBookVo.getPrice());
        bookEntity.setDescription(updateBookVo.getDescription());
        BookEntity savedBookEntity = bookRepository.save(bookEntity);

        return BookMapper.INSTANCE.bookToBookDto(savedBookEntity);
    }

    @Override
    public void deleteBookById(Long id) {
        BookEntity bookEntity = bookRepository.findByIdAndStatus(id, Status.ACTIVE)
                .orElseThrow(() -> new BookApiBusinessException(ADAPTER_VALIDATION_BOOK_NOT_FOUND));

        bookEntity.setStatus(Status.PASSIVE);
        bookRepository.save(bookEntity);
    }
}
