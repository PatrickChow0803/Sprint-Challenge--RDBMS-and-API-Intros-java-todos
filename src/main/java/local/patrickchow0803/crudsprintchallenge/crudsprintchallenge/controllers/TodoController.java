package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.controllers;

import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.Todo;
import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // Update a todo based on the ID of the todo
    // http://localhost:2019/todos/todo/9
    @PutMapping(value = "/todo/{todoId}",
                produces = {"application/json"})
    public ResponseEntity<?> updateTodo (@RequestBody Todo updateTodo, @PathVariable long todoId) {
        todoService.updateTodo(todoId, updateTodo);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
