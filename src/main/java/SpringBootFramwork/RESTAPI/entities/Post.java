package SpringBootFramwork.RESTAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long id;
    private String description;
    @ManyToOne
    private User user;
}
