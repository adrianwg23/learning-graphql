package com.adrianwong.learninggraphql.mutation;

import com.adrianwong.learninggraphql.model.Author;
import com.adrianwong.learninggraphql.model.AuthorWrapper;
import com.adrianwong.learninggraphql.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {

    private final AuthorRepository authorRepository;

    public AuthorMutationResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(AuthorWrapper authorWrapper) {
        Author author = new Author(authorWrapper.getName());
        return authorRepository.save(author);
    }
}
