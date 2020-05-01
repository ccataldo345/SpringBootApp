package com.chris.app.controller;

import com.chris.app.entity.Book;
import com.chris.app.repository.BookRepository;
import com.chris.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "edit-book";
    }

    @PostMapping("/{id}")
    public String updateBook(@PathVariable Long id, Book book, Model model) {
        Book editBook = bookService.getBook(id);
        editBook.setTitle(book.getTitle());
        editBook.setIsbn(book.getIsbn());
        editBook.setAuthor(book.getAuthor());
        book = bookRepository.save(editBook);
        model.addAttribute("book", book);
        return "redirect:/books";
    }

    @GetMapping("/add-book")
    public String addBook(Model model) {
        model.addAttribute("newBook", new Book());
        return "add-book";
    }

    @PostMapping
    public String addBook(Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}

