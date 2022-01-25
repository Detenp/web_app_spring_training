package fr.lernejo.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class TodoListController {
    private final TodoRepository repository;

    public TodoListController(TodoRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/api/todo")
    public ResponseEntity addToList(@RequestBody TodoEntity todo) {
        this.repository.save(todo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "/api/todo")
    public Iterable<TodoEntity>  getList() {
        //List<TodoEntity> toReturn = new LinkedList<>();
        //repository.findAll().forEach(toReturn::add);
        return repository.findAll();
    }
}
