package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.services;

import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.Role;
import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.Todo;
import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.User;
import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.repositories.RoleRepository;
import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.repositories.TodoRepository;
import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImplication implements UserService{

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    @Autowired
    TodoRepository todoRepo;

    @Transactional
    @Override
    public User user(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUserList = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(allUserList::add);
        return allUserList;
    }

    @Override
    public User getUserById(long id) {
        return userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public User addUser(User user) {
        User newUser = new User();

        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setPrimaryemail(user.getPrimaryemail());

        for (Role role : user.getRoles()){
            Role newRole = roleRepo.findById(role.getRoleid()).orElse(role);
            newUser.getRoles().add(newRole);
        }

        for (Todo todo : user.getTodos()){
            Todo newTodo = new Todo(todo.getDescription(), todo.getDatestarted(), todo.isCompleted(), newUser);
            newUser.getTodos().add(newTodo);
        }

        return userRepo.save(newUser);
    }

    @Override
    public Todo addTodoToUser(long userid, Todo todo) {
        User getUser = getUserById(userid);
        Todo newTodo = new Todo();

        newTodo.setUser(getUser);
        newTodo.setDescription(todo.getDescription());
        newTodo.setDatestarted(todo.getDatestarted());

        return todoRepo.save(newTodo);
    }
}
