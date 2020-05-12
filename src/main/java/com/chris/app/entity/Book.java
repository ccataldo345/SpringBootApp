package com.chris.app.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 50, message="Please do not exceed 50 characters.")
    private String title;

    @Size(max = 50, message="Please do not exceed 30 characters.")
    private String author;

    @Size(min = 14, max = 14, message="ISBN must have 14 characters.")
    private String isbn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    @Size(max = 50, message="Please do not exceed 50 characters.")
    private List<Comment> comments;

}



