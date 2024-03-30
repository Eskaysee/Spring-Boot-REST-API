package SpringBootFramwork.RESTAPI.controllers;

import SpringBootFramwork.RESTAPI.beans.User;
import SpringBootFramwork.RESTAPI.exceptions.UserNotFoundException;
import SpringBootFramwork.RESTAPI.services.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id) {
        User usr = service.findById(id);
        if (usr == null)
            throw new UserNotFoundException("id:" + id);
        return usr;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteById(@PathVariable int id) {
        return service.deleteById(id);
    }
}