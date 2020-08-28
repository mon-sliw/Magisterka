package pl.mis.magisterka.userservice.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mis.magisterka.userservice.entity.User;
import pl.mis.magisterka.userservice.entity.UserApiHelper;
import pl.mis.magisterka.userservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    RestTemplate restTemplate;

    @Override
    public List<User> getAll() {
        List<User> allUsers = new ArrayList<>();
        userRepository.findAll().forEach(allUsers::add);
        return allUsers;
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User editUser(Long id, User newUser) {
        if (userRepository.existsById(id)) {
            newUser.setId(id);
            return userRepository.save(newUser);
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean initDB() {
        try {
            String url = "https://randomuser.me/api/?results=50&seed=abc&nat=us&inc=name,email,login&noinfo";
            ResponseEntity<UserApiHelper> response = restTemplate.getForEntity(url, UserApiHelper.class);
            userRepository.saveAll(response.getBody().toUserList());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
