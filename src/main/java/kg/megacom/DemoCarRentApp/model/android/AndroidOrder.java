package kg.megacom.DemoCarRentApp.model.android;

import kg.megacom.DemoCarRentApp.model.Client;
import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AndroidOrder {
    private int currentAction;
    private float price;
    private String time;
    private Client client;
    private CarDto carDto;
}
