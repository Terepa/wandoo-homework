package models.payments;
import lombok.Data;


@Data
public class PaymentsResponseItem {
	private double amount;
	private int id;
	private String type;
	private String rawResponse;


}
