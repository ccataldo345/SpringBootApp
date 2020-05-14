package com.chris.app.controller;

import com.chris.app.entity.Book;
import com.chris.app.entity.Comment;
import com.chris.app.repository.BookRepository;
import com.chris.app.repository.CommentRepository;
import com.chris.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/books")
public class CommentController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/{id}/comments")
    public String getComments(@PathVariable Long id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        model.addAttribute("comments", book.getComments());
        model.addAttribute("comment", new Comment());
        return "comments";
    }

    @PostMapping("/{id}/comments")
    public String addComment(@PathVariable Long id, @Valid @ModelAttribute Comment comment, BindingResult bindingResult, Model model) {
        Book book = bookService.getBook(id);
        List<Comment> comments = book.getComments();
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comment.setDate(new Date());
        comment = commentRepository.save(comment);
        comments.add(comment);
        book.setComments(comments);
        if (bindingResult.hasErrors()) return "/comments";
        bookRepository.save(book);
        model.addAttribute("book", book);
        model.addAttribute("comment", new Comment());
        return "redirect:/books/{id}/comments";
    }
}
