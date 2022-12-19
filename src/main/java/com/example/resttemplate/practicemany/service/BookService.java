package com.example.resttemplate.practicemany.service;

import com.example.resttemplate.practicemany.model.Book;
import com.example.resttemplate.practicemany.model.BookResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service

public class BookService {

    private final RestTemplate restTemplate;


    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${test.newUrl}")
    private String url;

    public BookResponse addBook(Book book) {
        HttpEntity<Book> httpEntity = new HttpEntity<>(book);
        ResponseEntity<BookResponse> bookResponse = restTemplate.exchange(url + "/books", HttpMethod.POST, httpEntity, BookResponse.class);
        return bookResponse.getBody();

    }

    public Book getById(Long id) {
     Book book=restTemplate.getForObject(url+"/books/{id}", Book.class,id);
     log.info("get with id {} successfully",id);
     return book;
    }
}
