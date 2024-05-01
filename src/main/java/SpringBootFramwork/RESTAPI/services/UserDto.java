package SpringBootFramwork.RESTAPI.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class UserDto {

    private String name;

    private LocalDate birthDate;

    private String email;

}
