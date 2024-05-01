package SpringBootFramwork.RESTAPI.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter @ToString
public class UserDto {

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @JsonProperty("Birth Date")
    @Past(message = "Birth date should be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Email(message = "Email format should be: [localpart]@[domain]")
    private String email;

}
