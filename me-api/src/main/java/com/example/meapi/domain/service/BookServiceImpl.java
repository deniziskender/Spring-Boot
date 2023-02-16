package com.example.meapi.domain.service;

import com.example.meapi.application.adapter.api.book.response.BooksResponse;
import com.example.meapi.application.adapter.api.book.response.dto.BookDto;
import com.example.meapi.application.rest.response.MeResponse;
import com.example.meapi.domain.data.MeDto;
import com.example.meapi.domain.ports.api.BookServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookServicePort {

    private final BookApiServiceImpl bookApiService;

    @Override
    public MeResponse getBooks() {
        BooksResponse booksResponse = bookApiService.getBooks();
        return MeResponse.builder()
                .mes(retrieve(booksResponse.getBooks()))
                .build();
    }

    private List<MeDto> retrieve(List<BookDto> books) {
        List<MeDto> meDtos = new ArrayList<>();
        for (BookDto book : books) {
            MeDto meDto = MeDto.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .build();
            meDtos.add(meDto);
        }
        return meDtos;
    }
}
