package com.adrianwong.learninggraphql.service;

import com.adrianwong.learninggraphql.repository.AuthorRepository;
import com.adrianwong.learninggraphql.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
}
