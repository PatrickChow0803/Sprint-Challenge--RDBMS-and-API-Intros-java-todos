package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.services;

import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "todoService")
public class TodoServiceImplication implements TodoService{

    @Autowired
    TodoRepository todoRepo;

}
