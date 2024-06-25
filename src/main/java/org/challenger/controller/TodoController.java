package org.challenger.controller;

import org.challenger.entity.Todo;
import org.challenger.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    List<Todo> all() {
        return todoService.list();
    }

    @GetMapping("{id}")
    Todo byId(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @PostMapping
    List<Todo> create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }
}
