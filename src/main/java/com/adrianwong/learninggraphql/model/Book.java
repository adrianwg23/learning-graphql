package com.adrianwong.learninggraphql.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {
    @Id
    private String isbn;
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authors;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }
}
