package models.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static utils.Util.convertStringToBase64;
import static utils.Util.generateRandomValue;

@Data
public class RegisterUserRequest {

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    public RegisterUserRequest() {
        String uniqueName = "test_user_" + generateRandomValue();
        String newPassword = convertStringToBase64("password_example");

        password = newPassword;
        email = uniqueName + "@example.com";
    }
}