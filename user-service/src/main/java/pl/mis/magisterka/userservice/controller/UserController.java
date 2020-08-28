package pl.mis.magisterka.userservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mis.magisterka.userservice.entity.User;
import pl.mis.magisterka.userservice.service.UserService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return userService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User newUser) {
        User addedUser = userService.addUser(newUser);
        if (addedUser == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.ok(addedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestBody User newUser) {
        User updatedUser = userService.editUser(id, newUser);
        if (updatedUser == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedUser);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/init")
    public ResponseEntity<Void> initDB() {
        if (userService.initDB())
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}
