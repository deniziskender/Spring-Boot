package com.example.todoapi.application.rest;

import com.example.todoapi.application.response.TodoResponse;
import com.example.todoapi.application.response.TodosResponse;
import com.example.todoapi.base.BaseIT;
import com.example.todoapi.domain.data.TodoDto;
import com.example.todoapi.infrastructure.exception.TodoApiBusinessException;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TodoControllerTest extends BaseIT {

    @Test
    void should_get_all_todos() {
        //when
        ResponseEntity<TodosResponse> response = testRestTemplate.getForEntity("/todo/getAll", TodosResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        TodosResponse todosResponse = response.getBody();
        List<TodoDto> todoList = todosResponse.getTodos();
        assertThat(todoList).isNotEmpty();
        assertThat(todoList.size()).isEqualTo(4);

        TodoDto todoDto1 = todoList.get(0);
        assertThat(todoDto1.getId()).isEqualTo(1);
        assertThat(todoDto1.getExplanation()).isEqualTo(":wq!");

        TodoDto todoDto2 = todoList.get(1);
        assertThat(todoDto2.getId()).isEqualTo(2);
        assertThat(todoDto2.getExplanation()).isEqualTo("don't rely on the order @context +shopping");

        TodoDto todoDto3 = todoList.get(2);
        assertThat(todoDto3.getId()).isEqualTo(3);
        assertThat(todoDto3.getExplanation()).isEqualTo("one more thingy: @contexts and +projects can be everywhere");

        TodoDto todoDto4 = todoList.get(3);
        assertThat(todoDto4.getId()).isEqualTo(4);
        assertThat(todoDto4.getExplanation()).isEqualTo("xylophone +shopping +hobby");
    }

    @Test
    void should_get_todo_by_id() {
        // given
        Long id = 1L;

        //when
        ResponseEntity<TodoResponse> response = testRestTemplate.getForEntity("/todo/get/id/" + id, TodoResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        TodoResponse todoResponse = response.getBody();
        TodoDto todoDto = todoResponse.getTodoDto();
        assertThat(todoDto).isNotNull();

        assertThat(todoDto.getId()).isEqualTo(1);
        assertThat(todoDto.getExplanation()).isEqualTo(":wq!");
    }

    @Test
    void should_not_get_todo_by_id() {
        // given
        Long id = 5L;

        //when
        ResponseEntity<TodoApiBusinessException> response = testRestTemplate.getForEntity("/todo/get/id/" + id, TodoApiBusinessException.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    void should_get_by_project_filter() {
        //given
        String projectFilter = "hobby";

        //when
        ResponseEntity<TodosResponse> response = testRestTemplate.getForEntity("/todo/get/projectFilter/" + projectFilter, TodosResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        TodosResponse todosResponse = response.getBody();
        List<TodoDto> todoList = todosResponse.getTodos();
        assertThat(todoList).isNotEmpty();
        assertThat(todoList.size()).isEqualTo(1);

        TodoDto todoDto1 = todoList.get(0);
        assertThat(todoDto1.getId()).isEqualTo(1);
        assertThat(todoDto1.getExplanation()).isEqualTo("xylophone +shopping +hobby");
    }

    @Test
    void should_get_all_todos_as_txt() {
        //when
        ResponseEntity<Resource> response = testRestTemplate.getForEntity("/todo/getAllAsTxt/", Resource.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }
}