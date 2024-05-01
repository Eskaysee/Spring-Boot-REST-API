package SpringBootFramwork.RESTAPI.services;

import SpringBootFramwork.RESTAPI.entities.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    UserDto search(Long id);

    User insert(UserDto userDto);

    void deleteUser(Long id);

    UserDto convertToUserDto(User user);

    User convertToUserEntity(UserDto userDto);
}
