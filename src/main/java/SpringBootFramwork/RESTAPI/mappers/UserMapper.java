package SpringBootFramwork.RESTAPI.mappers;

import SpringBootFramwork.RESTAPI.entities.User;
import SpringBootFramwork.RESTAPI.services.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}
