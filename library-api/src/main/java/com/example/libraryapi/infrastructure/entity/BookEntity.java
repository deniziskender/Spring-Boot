package com.example.libraryapi.infrastructure.entity;

import com.example.libraryapi.infrastructure.enumtype.Status;
import com.example.libraryapi.infrastructure.enumtype.converter.StatusConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "book")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookEntity extends AbstractEntity {
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Convert(converter = StatusConverter.class)
    @Column(name = "status", nullable = false)
    private Status status;
}
