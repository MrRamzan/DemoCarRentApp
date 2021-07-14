package kg.megacom.DemoCarRentApp.model.android;

import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import kg.megacom.DemoCarRentApp.model.dto.ClientDto;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AndroidOrder {
    private int currentAction;
    private float price;
    private String time;
    private ClientDto client;
    private CarDto car;
}
