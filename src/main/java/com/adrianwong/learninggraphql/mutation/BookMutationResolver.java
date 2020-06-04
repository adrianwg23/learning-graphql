package com.adrianwong.learninggraphql.mutation;

import com.adrianwong.learninggraphql.model.Author;
import com.adrianwong.learninggraphql.model.Book;
import com.adrianwong.learninggraphql.model.BookWrapper;
import com.adrianwong.learninggraphql.repository.AuthorRepository;
import com.adrianwong.learninggraphql.repository.BookRepository;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

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
        Book book = new Book(bookWrapper.getIsbn(), bookWrapper.getTitle());
        book.setPublishedDate(bookWrapper.getPublishedDate());
        return bookRepository.save(book);
    }

    public Book addAuthor(Long authorId, String isbn) {
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        if (authorOptional.isPresent() && bookOptional.isPresent()) {
            Book book = bookOptional.get();
            Author author = authorOptional.get();
            author.addBook(book);
            book.addAuthor(author);
            authorRepository.save(author);
            bookRepository.save(book);
            return bookOptional.get();
        }
        throw new GraphQLException("couldn't add author");
    }
}
