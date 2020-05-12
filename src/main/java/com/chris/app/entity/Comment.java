package com.chris.app.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String commentText;
    private Date date;

}
