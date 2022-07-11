package com.example.libraryapi.domain.service;

import com.example.libraryapi.application.request.CreateBookRequest;
import com.example.libraryapi.base.BaseTest;
import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.domain.data.CreateBookVo;
import com.example.libraryapi.domain.ports.spi.BookPersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

class BookServiceImplTest extends BaseTest {

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
        BookDto response = bookService.addBook(createBookRequest);

        // then
        assertThat(response.getTitle()).isEqualTo(bookDto.getTitle());
        assertThat(response.getPrice()).isEqualTo(bookDto.getPrice());
        assertThat(response.getDescription()).isEqualTo(bookDto.getDescription());

        ArgumentCaptor<CreateBookVo> argumentCaptor = ArgumentCaptor.forClass(CreateBookVo.class);

        InOrder inOrder = inOrder(bookPersistencePort);
        inOrder.verify(bookPersistencePort).addBook(argumentCaptor.capture());
        inOrder.verifyNoMoreInteractions();

        CreateBookVo captorValue = argumentCaptor.getValue();
        assertThat(captorValue.getTitle()).isEqualTo("title");
        assertThat(captorValue.getDescription()).isEqualTo("description");
        assertThat(captorValue.getPrice()).isEqualTo(2.1);
    }
}