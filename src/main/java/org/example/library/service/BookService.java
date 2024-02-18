package org.example.library.service;


import org.example.library.dto.BookDTO;
import org.example.library.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Book saveBook(BookDTO bookDTO);

    Book updateBook(Long id, BookDTO bookDTO);

    void deleteBook(Long id);
}
