package com.example.todoapi.application.response;

import com.example.todoapi.domain.data.TodosDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodosPageResponse {
    private TodosDto todosDto;
}
