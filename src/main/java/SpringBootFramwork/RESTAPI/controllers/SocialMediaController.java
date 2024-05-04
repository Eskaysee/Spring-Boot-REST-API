package SpringBootFramwork.RESTAPI.controllers;

import SpringBootFramwork.RESTAPI.entities.Post;
import SpringBootFramwork.RESTAPI.entities.User;
import SpringBootFramwork.RESTAPI.services.PostDto;
import SpringBootFramwork.RESTAPI.services.UserDto;
import SpringBootFramwork.RESTAPI.services.SocialMediaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SocialMediaController {

    @Autowired
    private SocialMediaService socialMediaService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> usersList = socialMediaService.getAll();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public EntityModel<UserDto> findUserById(@PathVariable long id) {
        UserDto usr = socialMediaService.search(id);
        EntityModel<UserDto> model = EntityModel.of(usr);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        model.add(link.withRel("all-users"));
        return model;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {
        User user = socialMediaService.insert(userDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable long id) {
        socialMediaService.deleteUser(id);
    }

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<PostDto>> getAllUserPosts(@PathVariable long id) {
        List<PostDto> posts = socialMediaService.getAllPostsByUser(id);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/users/{id}/posts")
    public  ResponseEntity<PostDto> addPost(@PathVariable long id, @Valid @RequestBody PostDto postDto) {
        Post post = socialMediaService.savePost(id, postDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}