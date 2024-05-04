package SpringBootFramwork.RESTAPI.services;

import SpringBootFramwork.RESTAPI.entities.Post;
import SpringBootFramwork.RESTAPI.entities.User;
import SpringBootFramwork.RESTAPI.exceptions.UserNotFoundException;
import SpringBootFramwork.RESTAPI.mappers.SocialMediaMapper;
import SpringBootFramwork.RESTAPI.repositories.PostRepository;
import SpringBootFramwork.RESTAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialMediaServiceImpl implements SocialMediaService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return SocialMediaMapper.INSTANCE.userListToDto(users);
    }

    @Override
    public UserDto search(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        return SocialMediaMapper.INSTANCE.userToUserDto(user.get());
    }

    @Override
    public User insert(UserDto userDto) {
        User usr = SocialMediaMapper.INSTANCE.userDtoToUser(userDto);
        return userRepository.save(usr);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Override
    public List<PostDto> getAllPostsByUser(long user_id) {
        List<Post> posts = postRepository.findAllByUserId(user_id);
        return SocialMediaMapper.INSTANCE.postListToDto(posts);
    }

    @Override
    public Post savePost(long id, PostDto postDto) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        Post post = SocialMediaMapper.INSTANCE.postDtoToPost(postDto);
        post.setUser(user.get());
        return postRepository.save(post);
    }
}
