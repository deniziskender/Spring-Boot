package com.example.meapi.application.rest;

import com.example.meapi.application.rest.response.MeResponse;
import com.example.meapi.domain.ports.api.BookServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MeController {

    private final BookServicePort bookServicePort;

    @GetMapping("/v1/me/books")
    public MeResponse getAllBooks() {
        return bookServicePort.getBooks();
    }
}
