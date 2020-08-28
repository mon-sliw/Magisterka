package pl.mis.magisterka.userservice.service;

import pl.mis.magisterka.userservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    Optional<User> getById(Long id);

    User addUser(User user);

    User editUser(Long id, User user);

    boolean deleteUser(Long id);

    boolean initDB();
}
