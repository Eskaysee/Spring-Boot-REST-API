package SpringBootFramwork.RESTAPI.repositories;

import SpringBootFramwork.RESTAPI.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
