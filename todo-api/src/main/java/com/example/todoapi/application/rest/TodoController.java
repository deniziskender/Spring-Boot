package com.example.todoapi.application.rest;

import com.example.todoapi.application.response.TodoResponse;
import com.example.todoapi.application.response.TodosResponse;
import com.example.todoapi.domain.data.TodoDto;
import com.example.todoapi.domain.ports.api.TodoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoServicePort todoServicePort;

    @GetMapping("/getAll")
    public TodosResponse getAllTodos() {
        List<TodoDto> todos = todoServicePort.getTodos();
        return TodosResponse.builder().todos(todos).build();
    }

    @GetMapping("/get/id/{id}")
    public TodoResponse getTodoByID(@PathVariable long id) {
        TodoDto todoDto = todoServicePort.getTodoById(id);
        return TodoResponse.builder().todoDto(todoDto).build();
    }

    @GetMapping("/get/projectFilter/{projectFilter}")
    public TodosResponse getTodosByFilter(@PathVariable String projectFilter) {
        List<TodoDto> todos = todoServicePort.getTodoByProjectFilter(projectFilter);
        return TodosResponse.builder().todos(todos).build();
    }

    @GetMapping("/getAllAsTxt")
    public ResponseEntity<Resource> getAllAsTxt() {
        Resource resource = todoServicePort.getResource();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}
