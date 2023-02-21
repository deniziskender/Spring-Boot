package com.example.meapi.application.rest;

import com.example.meapi.application.rest.response.MeResponse;
import com.example.meapi.base.BaseIT;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource(properties = {"mock.library.api.service.enabled=false"})
class MeControllerTest2 extends BaseIT {

    @BeforeEach
    void setUp() {
        libraryApiWireMockServer.start();
    }

    @AfterEach
    void tearDown() {
        libraryApiWireMockServer.stop();
    }

    @Test
    void should_get_books() {

        String bookResponse = readWireMockFile("library/books.json");

        libraryApiWireMockServer.stubFor(get(urlEqualTo("/v1/books"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(bookResponse)
                        .withStatus(200)
                ));

        //when
        ResponseEntity<MeResponse> response = testRestTemplate.getForEntity("/v1/me/books", MeResponse.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        MeResponse booksResponse = response.getBody();
        assertThat(booksResponse.getMes()).isNotEmpty();
        assertEquals(1, booksResponse.getMes().size());
    }
}