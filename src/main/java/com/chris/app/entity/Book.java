package com.chris.app.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message="Please do not exceed 50 characters.")
    private String title;

    @Size(max = 50, message="Please do not exceed 30 characters.")
    private String author;

    @Size(min = 14, max = 14, message="ISBN must have 14 characters.")
    private String isbn;

}



