package SpringBootFramwork.RESTAPI.services;

import SpringBootFramwork.RESTAPI.entities.User;
import SpringBootFramwork.RESTAPI.exceptions.UserNotFoundException;
import SpringBootFramwork.RESTAPI.mappers.UserMapper;
import SpringBootFramwork.RESTAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(UserMapper.INSTANCE::userToUserDto).toList();
    }

    @Override
    public UserDto search(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        return UserMapper.INSTANCE.userToUserDto(user.get());
    }

    @Override
    public User insert(UserDto userDto) {
        User usr = UserMapper.INSTANCE.userDtoToUser(userDto);
        return userRepository.save(usr);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }
}
