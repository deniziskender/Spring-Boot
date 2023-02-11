package com.example.libraryapi.application.rest;

import com.example.libraryapi.application.request.CreateBookRequest;
import com.example.libraryapi.application.request.UpdateBookRequest;
import com.example.libraryapi.application.response.BookResponse;
import com.example.libraryapi.application.response.BooksPageResponse;
import com.example.libraryapi.application.response.BooksResponse;
import com.example.libraryapi.base.BaseIT;
import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.infrastructure.enumtype.Status;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookControllerTest extends BaseIT {

    @Test
    void should_get_book() {
        // given
        long id = 1;

        // when
        ResponseEntity<BookResponse> response = testRestTemplate.getForEntity("/v1/books/" + id, BookResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        BookResponse bookResponse = response.getBody();
        assertThat(bookResponse.getBook()).isNotNull();

        BookDto book = bookResponse.getBook();
        assertThat(book.getId()).isEqualTo(1L);
        assertThat(book.getTitle()).isEqualTo("The Lord of the Rings");
        assertThat(book.getDescription()).isEqualTo("Best-seller-1");
        assertThat(book.getPrice()).isEqualTo(20.1);
        assertThat(book.getStatus()).isEqualTo(Status.ACTIVE);
    }

    @Test
    void should_get_books() {
        // when
        ResponseEntity<BooksResponse> response = testRestTemplate.getForEntity("/v1/books/", BooksResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        BooksResponse booksResponse = response.getBody();
        assertThat(booksResponse.getBooks()).isNotEmpty();
        assertEquals(2, booksResponse.getBooks().size());
    }

    @Test
    void should_get_books_by_slicing() {
        // given
        PageRequest pageRequest = PageRequest.of(0, 1);

        HttpEntity<PageRequest> requestEntity = new HttpEntity<>(pageRequest);

        // when
        ResponseEntity<BooksPageResponse> response = testRestTemplate.
                exchange("/v1/books/slice/", HttpMethod.GET, requestEntity, BooksPageResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        BooksPageResponse booksPageResponse = response.getBody();
        assertThat(booksPageResponse.getBooksDto()).isNotNull();
        assertThat(booksPageResponse.getBooksDto().getBooks().size()).isEqualTo(2);
        assertThat(booksPageResponse.getBooksDto().isHasMore()).isFalse();
        assertThat(booksPageResponse.getBooksDto().getPage()).isZero();
        assertThat(booksPageResponse.getBooksDto().getPageSize()).isEqualTo(1);
    }

    @Test
    void should_add_book() {
        // given
        CreateBookRequest createBookRequest = CreateBookRequest.builder()
                .title("title")
                .description("description")
                .price(1.1)
                .build();

        // when
        ResponseEntity<BookResponse> response = testRestTemplate.postForEntity("/v1/books/add", createBookRequest, BookResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        BookResponse bookResponse = response.getBody();
        assertThat(bookResponse.getBook()).isNotNull();

        BookDto book = bookResponse.getBook();

        assertNotNull(book.getId());
        assertThat(book.getTitle()).isEqualTo("title");
        assertThat(book.getDescription()).isEqualTo("description");
        assertThat(book.getPrice()).isEqualTo(1.1);
    }

    @Test
    void should_update_book() {
        // given
        UpdateBookRequest updateBookRequest = UpdateBookRequest.builder()
                .title("title2")
                .description("description2")
                .price(20.2)
                .build();

        HttpEntity<UpdateBookRequest> requestEntity = new HttpEntity<>(updateBookRequest);

        // when
        ResponseEntity<BookResponse> response = testRestTemplate.
                exchange("/v1/books/update/1", HttpMethod.PUT, requestEntity, BookResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        BookResponse bookResponse = response.getBody();
        assertThat(bookResponse.getBook()).isNotNull();

        BookDto book = bookResponse.getBook();

        assertThat(book.getId()).isEqualTo(1);
        assertThat(book.getTitle()).isEqualTo("title2");
        assertThat(book.getDescription()).isEqualTo("description2");
        assertThat(book.getPrice()).isEqualTo(20.2);
    }

    @Test
    void should_delete_book() {
        // given
        long id = 1;

        // when
        ResponseEntity<Void> response = testRestTemplate.exchange("/v1/books/delete/" + id, HttpMethod.DELETE, null, Void.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}