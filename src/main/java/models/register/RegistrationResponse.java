package models.register;


import lombok.Data;

@Data
public class RegistrationResponse {

    private UserDetails user;
    private MessageDetails message;
}
