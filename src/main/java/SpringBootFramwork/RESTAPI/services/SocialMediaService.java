package SpringBootFramwork.RESTAPI.services;

import SpringBootFramwork.RESTAPI.entities.Post;
import SpringBootFramwork.RESTAPI.entities.User;

import java.util.List;

public interface SocialMediaService {

    List<UserDto> getAll();

    UserDto search(Long id);

    User insert(UserDto userDto);

    void deleteUser(Long id);

    List<PostDto> getAllPostsByUser(long user_id);

    Post savePost(long user_id, PostDto postDto);

}
