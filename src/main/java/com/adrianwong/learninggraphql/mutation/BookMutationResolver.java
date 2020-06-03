package com.adrianwong.learninggraphql.mutation;

import com.adrianwong.learninggraphql.model.Author;
import com.adrianwong.learninggraphql.model.Book;
import com.adrianwong.learninggraphql.model.BookWrapper;
import com.adrianwong.learninggraphql.repository.AuthorRepository;
import com.adrianwong.learninggraphql.repository.BookRepository;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookMutationResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createBook(BookWrapper bookWrapper) {
        return bookRepository.save(new Book(bookWrapper.getIsbn(), bookWrapper.getTitle()));
    }

    public Book addAuthor(String authorId, String isbn) {
        Optional<Author> author = authorRepository.findById(authorId);
        Optional<Book> book = bookRepository.findById(isbn);
        if (author.isPresent() && book.isPresent()) {
            book.get().addAuthor(author.get());
            bookRepository.save(book.get());
            return book.get();
        }
        throw new GraphQLException("couldn't add author");
    }
}
