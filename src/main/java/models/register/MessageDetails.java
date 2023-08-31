package models.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageDetails {

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

}
