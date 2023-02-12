package com.example.libraryapi.infrastructure.repository;

import com.example.libraryapi.infrastructure.entity.BookEntity;
import com.example.libraryapi.infrastructure.enumtype.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findByIdAndStatus(Long id, Status status);

    List<BookEntity> findByStatus(Status status);

    Page<BookEntity> findByStatus(Status status, Pageable pageable);
}
