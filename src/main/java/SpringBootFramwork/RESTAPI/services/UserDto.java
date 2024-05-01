package SpringBootFramwork.RESTAPI.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
public class UserDto {

    private String name;

    @JsonProperty("Birth Date")
    private LocalDate birthDate;

    private String email;

}
