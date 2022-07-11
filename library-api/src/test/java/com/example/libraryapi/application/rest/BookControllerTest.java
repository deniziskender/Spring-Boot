package com.example.libraryapi.application.rest;

import com.example.libraryapi.application.request.CreateBookRequest;
import com.example.libraryapi.application.response.BookResponse;
import com.example.libraryapi.application.response.BooksResponse;
import com.example.libraryapi.base.BaseIT;
import com.example.libraryapi.domain.data.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class BookControllerTest extends BaseIT {

    @Test
    void should_add_book() {
        //given
        CreateBookRequest createBookRequest = CreateBookRequest.builder().description("description").title("title").price(1.1).build();

        //when
        ResponseEntity<BookResponse> response = testRestTemplate.postForEntity("/book/add", createBookRequest, BookResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        BookResponse bookResponse = response.getBody();
        assertThat(bookResponse.getBook()).isNotNull();

        BookDto book = bookResponse.getBook();

        assertThat(book.getTitle()).isEqualTo("title");
        assertThat(book.getDescription()).isEqualTo("description");
        assertThat(book.getPrice()).isEqualTo(1.1);
    }

    @Test
    void should_get_all_books() {
        //when
        ResponseEntity<BooksResponse> response = testRestTemplate.getForEntity("/book/get", BooksResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        BooksResponse booksResponse = response.getBody();
        assertThat(booksResponse.getBooks()).isNotEmpty();
    }
}