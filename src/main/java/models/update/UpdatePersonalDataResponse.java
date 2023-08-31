package models.update;

import lombok.Data;
import models.register.MessageDetails;
import models.register.UserDetails;


@Data

public class UpdatePersonalDataResponse {

    private UserDetails user;
    private MessageDetails message;
}
