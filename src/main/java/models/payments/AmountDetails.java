package models.payments;

import Enums.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;


@Data
public class AmountDetails {

    @JsonProperty("currency")
    private Currency currency;

    @JsonProperty("amount")
    private double amount;

    public AmountDetails() {

        amount = ThreadLocalRandom.current().nextDouble(0, 100);
        currency = Currency.USD;
    }
}