package SpringBootFramwork.RESTAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

}
