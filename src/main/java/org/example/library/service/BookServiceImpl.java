package org.example.library.service;

import org.example.library.dto.BookDTO;
import org.example.library.entity.Author;
import org.example.library.entity.Book;
import org.example.library.repository.AuthorRepository;
import org.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setISBN(bookDTO.getISBN());

        Optional<Author> authorOptional = authorRepository.findById(bookDTO.getAuthorId());
        authorOptional.ifPresent(book::setAuthor);

        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, BookDTO bookDTO) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDTO.getTitle());
            book.setISBN(bookDTO.getISBN());

            Optional<Author> authorOptional = authorRepository.findById(bookDTO.getAuthorId());
            authorOptional.ifPresent(book::setAuthor);

            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

