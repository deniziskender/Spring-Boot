package com.example.todoapi.infrastructure.mappers;

import com.example.todoapi.domain.data.TodoDto;
import com.example.todoapi.infrastructure.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TodoMapper {

    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    @Mapping(source = "id", target = "id")
    TodoDto todoToTodoDto(Todo todo);

    Todo todoDtoToDto(TodoDto todoDto);

    List<TodoDto> todoListToTodoDtoList(List<Todo> todoList);

    List<Todo> todoDtoListToTodoList(List<TodoDto> todoDtoList);
}
