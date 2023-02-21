package com.example.meapi.application.adapter.api.book;

import com.example.meapi.application.adapter.api.book.response.BooksResponse;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@ConditionalOnProperty(value = "mock.library.api.service.enabled", havingValue = "false", matchIfMissing = true)
@FeignClient(name = "BOOK-SERVICE", url = "http://localhost:8081")
public interface RestBookApiClient extends BookApiClient {

    @Override
    @GetMapping("/v1/books")
    BooksResponse retrieveBooks();
}
