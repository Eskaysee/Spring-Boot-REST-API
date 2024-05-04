package SpringBootFramwork.RESTAPI.mappers;

import SpringBootFramwork.RESTAPI.entities.Post;
import SpringBootFramwork.RESTAPI.entities.User;
import SpringBootFramwork.RESTAPI.services.PostDto;
import SpringBootFramwork.RESTAPI.services.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SocialMediaMapper {

    SocialMediaMapper INSTANCE = Mappers.getMapper(SocialMediaMapper.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    List<UserDto> userListToDto(List<User> users);

    Post postDtoToPost(PostDto postDto);

    List<PostDto> postListToDto(List<Post> posts);
}
