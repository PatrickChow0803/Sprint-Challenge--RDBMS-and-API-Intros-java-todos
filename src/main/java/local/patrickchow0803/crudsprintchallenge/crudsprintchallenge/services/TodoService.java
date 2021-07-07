package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.services;

import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.Todo;

public interface TodoService {
    Todo updateTodo(long todoId, Todo todo);
}
