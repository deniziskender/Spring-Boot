package com.example.meapi.application.adapter.api.book;

import com.example.meapi.application.adapter.api.book.response.BooksResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(name = "BOOK-SERVICE", url = "http://localhost:8081")
public interface RestBookApiClient extends BookApiClient {

    @Override
    @GetMapping("/v1/books")
    BooksResponse retrieveBooks();
}
