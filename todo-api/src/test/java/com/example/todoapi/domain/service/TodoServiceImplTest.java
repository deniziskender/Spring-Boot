package com.example.todoapi.domain.service;

import com.example.todoapi.base.BaseTest;
import com.example.todoapi.domain.data.TodoDto;
import com.example.todoapi.domain.ports.spi.TodoPersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

class TodoServiceImplTest extends BaseTest {

    // TODO: More unit tests should be added.

    @InjectMocks
    private TodoServiceImpl todoService;

    @Mock
    private TodoPersistencePort todoPersistencePort;

    @Test
    void should_get_todo_by_id() {
        // given
        TodoDto todoDto = TodoDto.builder().id(1L).explanation("explanation").build();

        when(todoPersistencePort.getTodoById(1L)).thenReturn(todoDto);
        // when
        TodoDto response = todoService.getTodoById(1L);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getExplanation()).isEqualTo("explanation");
    }
}