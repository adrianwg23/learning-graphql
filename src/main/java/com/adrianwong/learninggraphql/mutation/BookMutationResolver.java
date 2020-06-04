package com.adrianwong.learninggraphql.mutation;

import com.adrianwong.learninggraphql.model.Book;
import com.adrianwong.learninggraphql.model.BookWrapper;
import com.adrianwong.learninggraphql.service.BookService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {

    private final BookService bookService;

    public BookMutationResolver(BookService bookService) {
        this.bookService = bookService;
    }

    public Book createBook(BookWrapper bookWrapper) {
        return bookService.createBook(bookWrapper);
    }

    public Book addAuthor(Long authorId, String isbn) {
        return bookService.addAuthorToBook(authorId, isbn);
    }
}
