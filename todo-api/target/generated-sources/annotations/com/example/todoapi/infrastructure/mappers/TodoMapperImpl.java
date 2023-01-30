package com.example.todoapi.infrastructure.mappers;

import com.example.todoapi.domain.data.TodoDto;
import com.example.todoapi.infrastructure.entity.Todo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-30T21:13:53+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.3 (JetBrains s.r.o)"
)
public class TodoMapperImpl implements TodoMapper {

    @Override
    public TodoDto todoToTodoDto(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        TodoDto.TodoDtoBuilder todoDto = TodoDto.builder();

        todoDto.id( todo.getId() );
        todoDto.explanation( todo.getExplanation() );

        return todoDto.build();
    }

    @Override
    public Todo todoDtoToDto(TodoDto todoDto) {
        if ( todoDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setId( todoDto.getId() );
        todo.setExplanation( todoDto.getExplanation() );

        return todo;
    }

    @Override
    public List<TodoDto> todoListToTodoDtoList(List<Todo> todoList) {
        if ( todoList == null ) {
            return null;
        }

        List<TodoDto> list = new ArrayList<TodoDto>( todoList.size() );
        for ( Todo todo : todoList ) {
            list.add( todoToTodoDto( todo ) );
        }

        return list;
    }

    @Override
    public List<Todo> todoDtoListToTodoList(List<TodoDto> todoDtoList) {
        if ( todoDtoList == null ) {
            return null;
        }

        List<Todo> list = new ArrayList<Todo>( todoDtoList.size() );
        for ( TodoDto todoDto : todoDtoList ) {
            list.add( todoDtoToDto( todoDto ) );
        }

        return list;
    }
}
