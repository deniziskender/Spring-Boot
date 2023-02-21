package com.example.meapi.application.rest;

import com.example.meapi.application.rest.response.MeResponse;
import com.example.meapi.base.BaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource(properties = "mock.library.api.service.enabled=true")
class MeControllerTest extends BaseIT {

    @Test
    void should_get_books() {
        // when
        ResponseEntity<MeResponse> response = testRestTemplate.getForEntity("/v1/me/books", MeResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        MeResponse booksResponse = response.getBody();
        assertThat(booksResponse.getMes()).isNotEmpty();
        assertEquals(2, booksResponse.getMes().size());
    }
}