package SpringBootFramwork.RESTAPI.controllers;

import SpringBootFramwork.RESTAPI.beans.User;
import SpringBootFramwork.RESTAPI.exceptions.UserNotFoundException;
import SpringBootFramwork.RESTAPI.services.UserDaoService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
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
    public MappingJacksonValue findAllUsers() {
        List<User> usersList = service.findAll();
        MappingJacksonValue mjv = new MappingJacksonValue(usersList);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "Birth Date");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);
        mjv.setFilters(filters);
        return mjv;
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