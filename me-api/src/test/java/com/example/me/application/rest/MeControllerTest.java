package com.example.me.application.rest;

import com.example.meapi.application.rest.response.MeResponse;
import com.example.me.base.BaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Sql(scripts = "/sql/insert_books.sql")
@Sql(scripts = "/sql/delete_books.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class MeControllerTest extends BaseIT {

    @Test
    void should_get_books() {
        // when
        ResponseEntity<MeResponse> response = testRestTemplate.getForEntity("/v1/books/", MeResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        MeResponse booksResponse = response.getBody();
        assertThat(booksResponse.getMes()).isNotEmpty();
        assertEquals(2, booksResponse.getMes().size());
    }
}