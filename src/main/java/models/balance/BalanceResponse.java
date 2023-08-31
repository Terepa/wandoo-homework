package models.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BalanceResponse {

    @JsonProperty("models/balance")
    private Double balance;

    private BalanceResponse(Double balance) {
        super();
        this.balance = balance;
    }
}

