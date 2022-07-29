package com.example.todoapi.domain.service;

import com.example.todoapi.domain.data.TodoDto;
import com.example.todoapi.domain.ports.api.TodoServicePort;
import com.example.todoapi.domain.ports.spi.TodoPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoServicePort {

    private final TodoPersistencePort todoPersistencePort;

    @Override
    public List<TodoDto> getTodos() {

        return todoPersistencePort.getTodos();
    }

    @Override
    public TodoDto getTodoById(Long todoId) {
        return todoPersistencePort.getTodoById(todoId);
    }

    @Override
    public List<TodoDto> getTodoByProjectFilter(String projectFilter) {
        return todoPersistencePort.getTodoByProjectFilter(projectFilter);
    }

    @Override
    public Resource getResource() {
        return todoPersistencePort.getResource();
    }
}
