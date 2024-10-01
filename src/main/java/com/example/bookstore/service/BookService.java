package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    // In-memory list of books
    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1, "Harry Potter", "9780743273565", 10.99),
            new Book(2, "Dune", "9780451524935", 8.99),
            new Book(3, "Sapiens", "9780061120084", 12.49)
    ));

    // Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Get book by ID
    public Book getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    // Add a new book
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    // Update a book by ID
    public Book updateBook(int id, Book book) {
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getId() == id) {
                books.set(i, book);
                return book;
            }
        }
        return null;
    }

    // Delete a book by ID
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
