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
    private final LinkedList<Todo> list = new LinkedList<Todo>();

    @PostMapping(value = "/api/todo")
    public ResponseEntity addToList(@RequestBody Todo todo) {
        list.add(todo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "/api/todo")
    public List<Todo> getList() {
        return list;
    }
}
