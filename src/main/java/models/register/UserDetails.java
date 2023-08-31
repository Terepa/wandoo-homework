package models.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class UserDetails {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("personalId")
    private int personalId;
}
