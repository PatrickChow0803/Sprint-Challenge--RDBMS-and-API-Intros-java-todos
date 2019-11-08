package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.services;

import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.Todo;
import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "todoService")
public class TodoServiceImplication implements TodoService{

    @Autowired
    TodoRepository todoRepo;

    @Autowired
    UserService userService;

    @Override
    public Todo updateTodo(long todoId, Todo todo) {
        Todo getTodo = todoRepo.findById(todoId).orElseThrow(() -> new EntityNotFoundException(Long.toString(todoId)));

        if (todo.getUser() != null) {
            getTodo.setUser(userService.getUserById(todo.getUser().getUserid()));
        }

        if (todo.getDescription() != null) {
            getTodo.setDescription(todo.getDescription());
        }

        if (todo.getDatestarted() != null) {
            getTodo.setDatestarted(todo.getDatestarted());
        }

        if (todo.isCompleted()) {
            getTodo.setCompleted(todo.isCompleted());
        }

        return todoRepo.save(getTodo);
    }
}
