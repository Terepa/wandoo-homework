package models.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

import static utils.Util.generateRandomValue;


@Data
public class UpdatePersonalDataRequest {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("personalId")
    private int personalId;



    public UpdatePersonalDataRequest() {
        String uniqueName = "test_Name_" + generateRandomValue();
        String uniqueSurname = "test_Surname_" + generateRandomValue();
        int uniquePersonalId = ThreadLocalRandom.current().nextInt(0,100);


        firstName = uniqueName;
        surname = uniqueSurname;
        personalId = uniquePersonalId;
    }

}
