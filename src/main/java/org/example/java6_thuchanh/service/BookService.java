package org.example.java6_thuchanh.service;

import org.example.java6_thuchanh.dto.BookRequest;
import org.example.java6_thuchanh.dto.BookResponse;

import javax.swing.*;
import java.util.List;

public interface BookService {
    List<BookResponse> findAll(); // lay du lieu

    BookResponse findById(Long id); // lay du lieu

    BookResponse addBook(BookRequest book);

    BookResponse updateBook(BookRequest book, Long id);

    void deleteBook(Long id);
//    BookResponse deleteBook(Long id);
}
