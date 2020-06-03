package com.adrianwong.learninggraphql.query;

import com.adrianwong.learninggraphql.model.Book;
import com.adrianwong.learninggraphql.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {

    private final BookRepository bookRepository;

    public BookQueryResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Connection<Book> books(int first, String after, DataFetchingEnvironment env) {
        List<Book> books = bookRepository.findAll();
        return new SimpleListConnection<>(books).get(env);
    }

    public Book getBook(String isbn) {
        return bookRepository.findById(isbn).get();
    }
}
