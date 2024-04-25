package SpringBootFramwork.RESTAPI.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@JsonIgnoreProperties({"id"})       //dependent on the variable name. Will need to be updated with variable name changes
public class User {

    private int id;

    @JsonProperty("Full Name")          //Customizes the field name in the response
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @JsonIgnore         //removes this field from response. Useful for passwords
    @Past(message = "Birth date should be in the past")
    private LocalDate birthDate;

    public User(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birthDate +
                '}';
    }
}
