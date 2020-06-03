package com.adrianwong.learninggraphql.query;

import com.adrianwong.learninggraphql.model.Book;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLQueryResolver {

    public Book getBook(String isbn) {
        return new Book("Learn GraphQL", "203123214");
    }
}
