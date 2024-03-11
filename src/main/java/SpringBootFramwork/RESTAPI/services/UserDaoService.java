package SpringBootFramwork.RESTAPI.services;

import SpringBootFramwork.RESTAPI.beans.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Alice", LocalDate.now()
                .minusYears(18)
                .minusMonths(1)));
        users.add(new User(2, "Bob", LocalDate.now()
                .minusYears(21)
                .plusMonths(3)
                .plusDays(5)));
        users.add(new User(3, "Cathy", LocalDate.now()
                .minusDays(7)
                .minusYears(25)));
        users.add(new User(4, "David", LocalDate.now()
                .minusYears(23)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(User usr) {
        int id = users.size() +1;
        while (findById(id) != null) id++;
        usr.setId(id);
        users.add(usr);
    }

    public boolean deleteById(int id) {
        User user = findById(id);
        if (user != null) {
            return users.remove(user);
        }
        return false;
    }

}
