package com.example.meapi.domain.ports.api;

import com.example.meapi.application.rest.response.MeResponse;

public interface BookServicePort {

    MeResponse getBooks();
}
