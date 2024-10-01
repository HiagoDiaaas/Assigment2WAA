package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    // Constructor Injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 1. GET /books - Return a list of books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // 2. GET /books/{id} - Return a single book by ID
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // 3. POST /books - Add a new book
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // 4. PUT /books/{id} - Update a book by ID
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    // 5. DELETE /books/{id} - Delete a book by ID
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    // 6. Versioning Endpoints

    // a. URI Versioning: GET /v1/books
    @GetMapping("/v1/books")
    public List<Book> getAllBooksV1() {
        return bookService.getAllBooks();
    }

    // b. Request Parameter Versioning: GET /books?version=1
    @GetMapping(value = "/books", params = "version=1")
    public List<Book> getAllBooksRequestParam() {
        return bookService.getAllBooks();
    }

    // c. Custom Header Versioning: GET /books with header X-API-VERSION=2
    @GetMapping(value = "/books", headers = "X-API-VERSION=2")
    public List<Book> getAllBooksCustomHeader() {
        return bookService.getAllBooks();
    }

    // d. Media Type Versioning: GET /books/{id} with Accept header
    @GetMapping(value = "/books/{id}", produces = "application/cs.miu.edu-v2+json")
    public Book getBookByIdMediaType(@PathVariable int id) {
        return bookService.getBookById(id);
    }

}
