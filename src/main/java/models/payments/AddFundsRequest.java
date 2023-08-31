package models.payments;

import Enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

import static utils.Util.generateRandomValue;


public @Data class AddFundsRequest {

    @JsonProperty("accountHolderFullName")
    private String accountHolderFullName;

    @JsonProperty("accountHolderPersonalId")
    private String accountHolderPersonalId;

    @JsonProperty("transactionType")
    private TransactionType transactionType;

    @JsonProperty("investorId")
    private String investorId;

    private AmountDetails amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String bookingDate;

    @JsonProperty("accountNumber")
    private String accountNumber;


    public AddFundsRequest() {
        String uniqueFullName = "test_fullName_" + generateRandomValue();
        String uniqueSurname = "test_peronalId_" + generateRandomValue();
        String uniqueInvestorId =  generateRandomValue();
        String uniqueAccountNumber =  generateRandomValue();

        bookingDate = LocalDate.now().toString();
        accountHolderFullName = uniqueFullName;
        accountHolderPersonalId = uniqueSurname;
        transactionType = TransactionType.FUNDING;
        investorId = uniqueInvestorId;
        accountNumber = uniqueAccountNumber;
        amount = new AmountDetails();
    }
}
