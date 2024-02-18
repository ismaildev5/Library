package org.example.library.controller;



import org.example.library.dto.BookDTO;
import org.example.library.entity.Book;
import org.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).orElse(null);
    }

    @PostMapping
    public Book addBook(@RequestBody BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}

