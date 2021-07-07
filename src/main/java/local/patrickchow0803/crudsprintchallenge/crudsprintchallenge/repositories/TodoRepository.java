package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.repositories;

import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
