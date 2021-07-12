package kg.megacom.DemoCarRentApp.model.android;

import kg.megacom.DemoCarRentApp.model.Tariff;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AndroidCar {
    private Long id;
    private String name;
    private String transmission;
    private String year;
    private Tariff tariff;
}
