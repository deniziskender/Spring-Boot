package com.example.todoapi.domain.ports.spi;

import com.example.todoapi.domain.data.TodoDto;
import org.springframework.core.io.Resource;

import java.util.List;

public interface TodoPersistencePort {

    List<TodoDto> getTodos();
    TodoDto getTodoById(Long todoId);

    List<TodoDto> getTodoByProjectFilter(String projectFilter);

    Resource getResource();
}
