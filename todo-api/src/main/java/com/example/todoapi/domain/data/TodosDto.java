package com.example.todoapi.domain.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodosDto {
    private List<TodoDto> todos;
    private boolean hasMore;
    private Integer page;
    private Integer pageSize;
}
