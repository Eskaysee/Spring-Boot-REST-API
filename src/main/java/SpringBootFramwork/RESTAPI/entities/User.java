package SpringBootFramwork.RESTAPI.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity(name = "`User`")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class User {

    @GeneratedValue
    private @Id Long id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @JsonProperty("Birth Date")
    @Past(message = "Birth date should be in the past")
    @Column(name = "birth-date")
    private LocalDate birthDate;

    @Email
    @Column(name = "email-address")
    private String email;

}
