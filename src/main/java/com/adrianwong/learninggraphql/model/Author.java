package com.adrianwong.learninggraphql.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {
    @Id
    private String id;
    private String name;
    @ManyToMany
    private List<Book> books;

    public Author(String name) {
        this.name = name;
    }
}
