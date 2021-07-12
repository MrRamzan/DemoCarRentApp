package kg.megacom.DemoCarRentApp.model.android;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderPay {

    private int orderId;
    private int carId;
    private int clientId;
    private String carName;
    private String time;
    private float price;

}
