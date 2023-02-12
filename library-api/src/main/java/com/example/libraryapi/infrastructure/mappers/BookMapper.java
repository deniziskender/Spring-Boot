package com.example.libraryapi.infrastructure.mappers;

import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.infrastructure.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto bookToBookDto(BookEntity bookEntity);

    BookEntity bookDtoToBook(BookDto bookDto);

    List<BookDto> bookListToBookDtoList(List<BookEntity> bookEntityList);
}
