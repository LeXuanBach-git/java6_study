package org.example.java6_thuchanh.service;

import org.example.java6_thuchanh.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAll();

    Todo findById(Long id);

    Todo add(Todo todo);

    Todo update(Todo todo, Long id);

    Todo delete(Long id);
}
