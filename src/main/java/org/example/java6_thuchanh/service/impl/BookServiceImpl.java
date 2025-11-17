package org.example.java6_thuchanh.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.java6_thuchanh.dto.BookRequest;
import org.example.java6_thuchanh.dto.BookResponse;
import org.example.java6_thuchanh.exception.CustomResourceNotFoundException;
import org.example.java6_thuchanh.model.Book;
import org.example.java6_thuchanh.repository.BookRepository;
import org.example.java6_thuchanh.service.BookService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BookResponse> findAll() {
        return bookRepository
                .findAll()
                .stream()
                .map(book -> modelMapper.map(book, BookResponse.class))
                .toList();
    }

    @Override
    public BookResponse findById(Long id) {
        return bookRepository
                .findById(id)
                .map(book -> modelMapper.map(book, BookResponse.class))
                .orElseThrow(() -> new CustomResourceNotFoundException("Book not found" + id));
    }

    @Override
    public BookResponse addBook(BookRequest bookRequest) {
        Book book = modelMapper.map(bookRequest, Book.class);
        book.setIsbn(generateIsbn());
        BookResponse bookResponse = modelMapper.map(book, BookResponse.class);
        return bookResponse;
//        return modelMapper.map(bookResponse, BookResponse.class);
    }

    private String generateIsbn() {
        return "ISBN-" + UUID.randomUUID().toString().substring(0,13);
    }

    @Override
    public BookResponse updateBook(BookRequest bookRequest, Long id) {
        return bookRepository
                .findById(id)
                .map(b -> {
                    if (bookRequest.getTitle() != null) b.setTitle(bookRequest.getTitle());
                    if (bookRequest.getAuthor() != null) b.setAuthor(bookRequest.getAuthor());
                    if (bookRequest.getPrice() != 0) b.setPrice(bookRequest.getPrice());

                    bookRepository.save(b);
                    return modelMapper.map(b, BookResponse.class);
                })
                .orElseThrow(() -> new CustomResourceNotFoundException("Book not found" + id));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
