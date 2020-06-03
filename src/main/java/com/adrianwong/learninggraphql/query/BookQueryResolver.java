package com.adrianwong.learninggraphql.query;

import com.adrianwong.learninggraphql.model.Book;
import com.adrianwong.learninggraphql.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {

    private final BookRepository bookRepository;

    public BookQueryResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(String isbn) {
        return bookRepository.findById(isbn).get();
    }
}
