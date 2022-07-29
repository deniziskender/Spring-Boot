package com.example.todoapi.infrastructure.adapters;

import com.example.todoapi.domain.data.TodoDto;
import com.example.todoapi.domain.ports.spi.TodoPersistencePort;
import com.example.todoapi.infrastructure.entity.Todo;
import com.example.todoapi.infrastructure.exception.TodoApiBusinessException;
import com.example.todoapi.infrastructure.mappers.TodoMapper;
import com.example.todoapi.infrastructure.repository.FileRepositoryReader;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TodoJpaAdapter implements TodoPersistencePort {

    private final FileRepositoryReader fileRepositoryReader;

    @Override
    public List<TodoDto> getTodos() {
        Map<Long, Todo> todoMap = generateTodoMap(null);
        return TodoMapper.INSTANCE.todoListToTodoDtoList(new ArrayList<>(todoMap.values()));
    }

    @Override
    public TodoDto getTodoById(Long todoId) {
        Map<Long, Todo> todoMap = generateTodoMap(null);
        Todo todo = todoMap.get(todoId);
        if (Objects.isNull(todo)) {
            throw new TodoApiBusinessException("adapter.validation.todo.not.found");
        }
        return TodoMapper.INSTANCE.todoToTodoDto(todo);
    }

    @Override
    public List<TodoDto> getTodoByProjectFilter(String projectFilter) {
        Map<Long, Todo> todoMap = generateTodoMap(projectFilter);
        return TodoMapper.INSTANCE.todoListToTodoDtoList(new ArrayList<>(todoMap.values()));
    }

    @Override
    public Resource getResource() {
        return fileRepositoryReader.getResource();
    }

    private Map<Long, Todo> generateTodoMap(String projectFilter) {
        ArrayList<String> todoList = fileRepositoryReader.getTodoMap(projectFilter);
        Long counter = 0L;
        Map<Long, Todo> todoMap = new HashMap<>();
        for (String todo : todoList) {
            todoMap.put(++counter, generateTodo(counter, todo));
        }
        return todoMap;
    }

    private Todo generateTodo(Long counter, String explanation) {
        Todo todo = new Todo();
        todo.setId(counter);
        todo.setExplanation(explanation);
        return todo;
    }
}
