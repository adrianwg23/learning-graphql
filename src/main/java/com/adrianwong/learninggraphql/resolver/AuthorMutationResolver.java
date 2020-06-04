package com.adrianwong.learninggraphql.resolver;

import com.adrianwong.learninggraphql.model.Author;
import com.adrianwong.learninggraphql.model.AuthorWrapper;
import com.adrianwong.learninggraphql.service.AuthorService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {

    private final AuthorService authorService;

    public AuthorMutationResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Author createAuthor(AuthorWrapper authorWrapper) {
        return authorService.createAuthor(authorWrapper.getName());
    }

    public Author addBook(Long authorId, String isbn) {
        return authorService.addBookToAuthor(authorId, isbn);
    }

}
