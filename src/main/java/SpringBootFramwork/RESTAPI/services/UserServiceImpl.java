package SpringBootFramwork.RESTAPI.services;

import SpringBootFramwork.RESTAPI.entities.User;
import SpringBootFramwork.RESTAPI.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ModelMapper modelMapper;

//    private static List<User> users = new ArrayList<>();
//
//    static {
//        users.add(new User(1l, "Alice", LocalDate.now()
//                .minusYears(18)
//                .minusMonths(1), "alice@gmail.com"));
//        users.add(new User(2l, "Bob", LocalDate.now()
//                .minusYears(21)
//                .plusMonths(3)
//                .plusDays(5), "bob@outlook.com"));
//        users.add(new User(3l, "Cathy", LocalDate.now()
//                .minusDays(7)
//                .minusYears(25), "cathy@yahooo.com"));
//        users.add(new User(4l, "David", LocalDate.now()
//                .minusYears(23), "david@telkomsa.net"));
//    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(this::convertToUserDto).toList();
    }

    @Override
    public UserDto search(Long id) {
        return convertToUserDto(userRepository.findById(id).get());
    }

    @Override
    public User insert(UserDto userDto) {
        User usr = convertToUserEntity(userDto);
        return userRepository.save(usr);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Override
    public UserDto convertToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User convertToUserEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
