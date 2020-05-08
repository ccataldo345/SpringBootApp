package com.chris.app.controller;

import com.chris.app.entity.Book;
import com.chris.app.entity.Comment;
import com.chris.app.repository.BookRepository;
import com.chris.app.repository.CommentRepository;
import com.chris.app.service.BookService;
import com.chris.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/books")
public class CommentController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}/comments")
    public String getComments(@PathVariable Long id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        model.addAttribute("comments", book.getComments());
        return "comments";
    }

/*    @PostMapping("/{id}/comments")
    public String addComment(@PathVariable Long id, @Valid @ModelAttribute Comment comment, BindingResult bindingResult, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        model.addAttribute("comments", new Comment());
        comment.setDate(new Date());
        if (bindingResult.hasErrors()) return "/{id}/comments";
        commentRepository.save(comment);
        return "/{id}/comments";
    }*/
}
