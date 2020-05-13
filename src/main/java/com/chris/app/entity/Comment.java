package com.chris.app.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 50, message = "Please do not exceed 50 characters.")
    private String commentText;

    private Date date;
}
