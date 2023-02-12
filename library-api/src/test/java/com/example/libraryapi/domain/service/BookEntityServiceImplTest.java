package com.example.libraryapi.domain.service;

import com.example.libraryapi.application.request.CreateBookRequest;
import com.example.libraryapi.application.response.BookResponse;
import com.example.libraryapi.base.BaseTest;
import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.domain.data.CreateBookVo;
import com.example.libraryapi.domain.ports.spi.BookPersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

class BookEntityServiceImplTest extends BaseTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookPersistencePort bookPersistencePort;

    @Test
    void should_add_book() {
        // given
        BookDto bookDto = BookDto.builder().title("title").description("description").price(2.1).build();
        when(bookPersistencePort.addBook(any(CreateBookVo.class))).thenReturn(bookDto);

        CreateBookRequest createBookRequest = CreateBookRequest.builder().title("title").price(2.1).description("description").build();

        // when
        BookResponse response = bookService.addBook(createBookRequest);

        // then
        assertNotNull(response.getBook());
        assertEquals(bookDto.getTitle(), response.getBook().getTitle());
        assertEquals(bookDto.getPrice(), response.getBook().getPrice());
        assertEquals(bookDto.getDescription(), response.getBook().getDescription());

        ArgumentCaptor<CreateBookVo> argumentCaptor = ArgumentCaptor.forClass(CreateBookVo.class);

        InOrder inOrder = inOrder(bookPersistencePort);
        inOrder.verify(bookPersistencePort).addBook(argumentCaptor.capture());
        inOrder.verifyNoMoreInteractions();

        CreateBookVo captorValue = argumentCaptor.getValue();
        assertEquals("title", captorValue.getTitle());
        assertEquals("description", captorValue.getDescription());
        assertEquals(2.1, captorValue.getPrice());
    }
}