package com.example.todoapi.infrastructure.repository;

import com.example.todoapi.infrastructure.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<Todo> findById(Long id);
}
