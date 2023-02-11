package com.example.libraryapi.infrastructure.enumtype.converter;

import com.example.libraryapi.infrastructure.enumtype.Status;

import javax.persistence.AttributeConverter;

public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status status) {
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer value) {
        return Status.fromValue(value);
    }
}
