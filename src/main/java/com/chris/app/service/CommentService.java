package com.chris.app.service;

import com.chris.app.entity.Book;
import com.chris.app.entity.Comment;
import com.chris.app.repository.BookRepository;
import com.chris.app.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment getComment(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No comment found with this id"));
    }

}
