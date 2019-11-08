package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.services;

import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.Todo;
import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    User addUser(User user);

    Todo addTodoToUser(long userid, Todo todo);

}
