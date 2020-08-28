package pl.mis.magisterka.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mis.magisterka.userservice.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
