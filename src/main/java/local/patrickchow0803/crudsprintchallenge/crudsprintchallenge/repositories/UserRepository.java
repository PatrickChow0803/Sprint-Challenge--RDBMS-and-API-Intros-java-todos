package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.repositories;

import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
