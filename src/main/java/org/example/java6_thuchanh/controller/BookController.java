package org.example.java6_thuchanh.controller;

import jakarta.servlet.ServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.java6_thuchanh.dto.BookRequest;
import org.example.java6_thuchanh.dto.BookResponse;
import org.example.java6_thuchanh.model.Book;
import org.example.java6_thuchanh.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        List<BookResponse> books = bookService.findAll();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable Long id) {
        BookResponse book = bookService.findById(id);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest book) {
        BookResponse bookResponse = bookService.addBook(book);
        return ResponseEntity.ok().body(bookResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @RequestBody BookRequest book) {
        BookResponse bookResponse = bookService.updateBook(book,id);
        return ResponseEntity.ok().body(bookResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return  ResponseEntity.noContent().build(); // 204
    }
}
