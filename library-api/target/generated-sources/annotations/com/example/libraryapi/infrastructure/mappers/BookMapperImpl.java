package com.example.libraryapi.infrastructure.mappers;

import com.example.libraryapi.domain.data.BookDto;
import com.example.libraryapi.infrastructure.entity.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T01:24:20+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.3 (JetBrains s.r.o)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto bookToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto.BookDtoBuilder bookDto = BookDto.builder();

        bookDto.id( book.getId() );
        bookDto.title( book.getTitle() );
        bookDto.description( book.getDescription() );
        bookDto.price( book.getPrice() );
        bookDto.status( book.getStatus() );

        return bookDto.build();
    }

    @Override
    public Book bookDtoToBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setTitle( bookDto.getTitle() );
        book.setDescription( bookDto.getDescription() );
        book.setPrice( bookDto.getPrice() );
        book.setStatus( bookDto.getStatus() );

        return book;
    }

    @Override
    public List<BookDto> bookListToBookDtoList(List<Book> bookList) {
        if ( bookList == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( bookList.size() );
        for ( Book book : bookList ) {
            list.add( bookToBookDto( book ) );
        }

        return list;
    }
}
