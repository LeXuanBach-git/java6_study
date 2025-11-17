package org.example.java6_thuchanh.controller;

import jakarta.servlet.ServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.java6_thuchanh.model.Todo;
import org.example.java6_thuchanh.service.TodoService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    
    private final TodoService todoService;

//    get All
    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {

        List<Todo> todos = todoService.findAll();
//        return ResponseEntity.ok(todos);

//        return new ResponseEntity<>(todos, HttpStatus.OK);

//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Custom-Header", "custom-value");
//        return new ResponseEntity<>(todos, headers, HttpStatus.OK);

//        return ResponseEntity.status(HttpStatus.OK).body(todos);

        return ResponseEntity.ok().header("Custom-Header", "Custom-value").body(todos);
    }

//    get by ID
    @GetMapping("{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id) {

        Todo todo = todoService.findById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> add(@Valid @RequestBody Todo todo) {
        Todo savedTodo = todoService.add(todo);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> update(@Valid @RequestBody Todo todo, @PathVariable Long id) {
        Todo updatedTodo = todoService.update(todo, id);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Todo> delete(@PathVariable Long id) {
        Todo deleted = todoService.delete(id);
        return new  ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
