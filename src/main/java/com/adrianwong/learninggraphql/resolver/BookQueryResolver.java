package com.adrianwong.learninggraphql.resolver;

import com.adrianwong.learninggraphql.model.Book;
import com.adrianwong.learninggraphql.service.BookService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {

    private final BookService bookService;

    public BookQueryResolver(BookService bookService) {
        this.bookService = bookService;
    }

    public Connection<Book> books(int first, String after, DataFetchingEnvironment env) {
        List<Book> books = bookService.getAllBooks();
        return new SimpleListConnection<>(books).get(env);
    }

    public Book getBook(String isbn) {
        return bookService.getBookByIsbn(isbn);
    }
}
