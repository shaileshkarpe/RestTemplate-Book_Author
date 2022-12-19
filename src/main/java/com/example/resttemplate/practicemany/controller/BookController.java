package com.example.resttemplate.practicemany.controller;


import com.example.resttemplate.practicemany.model.Book;
import com.example.resttemplate.practicemany.model.BookResponse;
import com.example.resttemplate.practicemany.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
   private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping(value ="/books",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> addBook(@RequestBody Book book){
        BookResponse bookResponse=bookService.addBook(book);
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }
    @GetMapping(value = "/books/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        Book book=bookService.getById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
}