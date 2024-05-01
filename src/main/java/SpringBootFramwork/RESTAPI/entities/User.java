package SpringBootFramwork.RESTAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "user_details")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class User {

    @GeneratedValue
    private @Id Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

}
