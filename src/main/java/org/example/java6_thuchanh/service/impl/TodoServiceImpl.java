package org.example.java6_thuchanh.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.java6_thuchanh.exception.CustomResourceNotFoundException;
import org.example.java6_thuchanh.model.Todo;
import org.example.java6_thuchanh.repository.TodoRepository;
import org.example.java6_thuchanh.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.util.ClassUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {


    private final TodoRepository todoRepository;

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(Long id) {

        return todoRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("Todo not found" + id));
    }

    @Override
    public Todo add(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Todo todo, Long id) {
        return todoRepository.findById(id)
                .map(existing -> {
                    if(todo.getTitle() != null) existing.setTitle(todo.getTitle());
                    if (todo.getDescription() != null) existing.setDescription((todo.getDescription()));
                    existing.setCompleted(todo.isCompleted());

                    return todoRepository.save(existing);
                }).orElseThrow(() -> new CustomResourceNotFoundException("Todo not found " + id));
    }

    @Override
    public Todo delete(Long id) {
        Todo deletedTodo = findById(id);
        if (deletedTodo != null) {
            todoRepository.deleteById(id);
        } else {
            throw new CustomResourceNotFoundException("Todo not found" + id);
        }
        return deletedTodo;
    }
}
