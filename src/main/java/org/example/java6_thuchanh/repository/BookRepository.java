package org.example.java6_thuchanh.repository;

import org.example.java6_thuchanh.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
