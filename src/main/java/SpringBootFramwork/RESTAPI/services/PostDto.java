package SpringBootFramwork.RESTAPI.services;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PostDto {

    @Size(min = 3, message = "Post shouldn't be less than 3 characters")
    private String description;
}
