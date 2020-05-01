package com.chris.app.service;

import com.chris.app.entity.Book;
import com.chris.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No book found with this id"));
    }

}
