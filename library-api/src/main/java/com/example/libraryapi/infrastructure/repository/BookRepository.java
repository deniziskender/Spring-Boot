package com.example.libraryapi.infrastructure.repository;

import com.example.libraryapi.infrastructure.entity.Book;
import com.example.libraryapi.infrastructure.enumtype.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIdAndStatus(Long id, Status status);

    List<Book> findByStatus(Status status);

}
