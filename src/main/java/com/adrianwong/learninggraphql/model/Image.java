package com.adrianwong.learninggraphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Image {

    @Id
    private String id;
    private String url;
    private String title;
    private String publisher;
    private String publishDate;
}
