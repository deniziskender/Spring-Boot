package com.example.todoapi.infrastructure.repository;

import com.example.todoapi.infrastructure.exception.TodoApiBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileRepositoryReader {
    private static final String PROJECT_FILTER_SIGN = "+";
    private static final String SEPARATOR = " ";

    @Value("classpath:todo.txt")
    private Resource resource;

    public List<String> getTodoMap(String projectFilter) {
        ArrayList<String> todoList = new ArrayList<>();
        try {
            InputStream inputStream = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String explanation;
            while ((explanation = br.readLine()) != null) {
                if (isProjectFilterIncluded(explanation, projectFilter)) {
                    todoList.add(explanation);
                }
            }
        } catch (IOException e) {
            throw new TodoApiBusinessException("adapter.validation.unexpected.exception.occurred");
        }
        return todoList;
    }

    public Resource getResource() {
        return resource;
    }

    private boolean isProjectFilterIncluded(String explanation, String projectFilter) {
        if (Objects.isNull(projectFilter)) {
            return true;
        }
        String[] split = explanation.split(SEPARATOR);
        List<String> words = Arrays.asList(split);
        return words.contains(PROJECT_FILTER_SIGN + projectFilter);
    }
}
