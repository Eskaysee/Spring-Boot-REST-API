package SpringBootFramwork.RESTAPI.controllers;

import SpringBootFramwork.RESTAPI.beans.User;
import SpringBootFramwork.RESTAPI.exceptions.UserNotFoundException;
import SpringBootFramwork.RESTAPI.services.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public List<User> findAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> findUserById(@PathVariable int id) {
        User usr = service.findById(id);
        if (usr == null)
            throw new UserNotFoundException("id:" + id);

        EntityModel<User> model = EntityModel.of(usr);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAllUsers());
        model.add(link.withRel("all-users"));
        return model;
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
    public boolean deleteUserById(@PathVariable int id) {
        return service.deleteById(id);
    }
}