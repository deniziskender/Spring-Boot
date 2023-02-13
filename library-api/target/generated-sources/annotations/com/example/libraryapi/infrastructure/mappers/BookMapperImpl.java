package com.example.libraryapi.infrastructure.mappers;

import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.infrastructure.entity.BookEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T00:24:22+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.3 (JetBrains s.r.o)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto bookToBookDto(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookDto.BookDtoBuilder bookDto = BookDto.builder();

        bookDto.id( bookEntity.getId() );
        bookDto.createdAt( bookEntity.getCreatedAt() );
        bookDto.updatedAt( bookEntity.getUpdatedAt() );
        bookDto.title( bookEntity.getTitle() );
        bookDto.description( bookEntity.getDescription() );
        bookDto.price( bookEntity.getPrice() );
        bookDto.status( bookEntity.getStatus() );

        return bookDto.build();
    }

    @Override
    public BookEntity bookDtoToBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setId( bookDto.getId() );
        bookEntity.setCreatedAt( bookDto.getCreatedAt() );
        bookEntity.setUpdatedAt( bookDto.getUpdatedAt() );
        bookEntity.setTitle( bookDto.getTitle() );
        bookEntity.setDescription( bookDto.getDescription() );
        bookEntity.setPrice( bookDto.getPrice() );
        bookEntity.setStatus( bookDto.getStatus() );

        return bookEntity;
    }

    @Override
    public List<BookDto> bookListToBookDtoList(List<BookEntity> bookEntityList) {
        if ( bookEntityList == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( bookEntityList.size() );
        for ( BookEntity bookEntity : bookEntityList ) {
            list.add( bookToBookDto( bookEntity ) );
        }

        return list;
    }
}
