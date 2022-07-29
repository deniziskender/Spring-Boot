package com.example.todoapi.application.response;

import com.example.todoapi.domain.data.TodoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponse {
    private TodoDto todoDto;
}
