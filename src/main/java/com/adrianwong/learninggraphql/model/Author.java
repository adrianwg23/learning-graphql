package com.adrianwong.learninggraphql.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(
            cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            mappedBy = "authors"
    )
    private Set<Book> books;

    public Author(String name) {
        this.name = name;
    }
}
