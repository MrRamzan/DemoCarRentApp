package kg.megacom.DemoCarRentApp.model.android;

import kg.megacom.DemoCarRentApp.model.Locations;
import lombok.Data;

import java.util.Date;

@Data
public class CarData {

    private Long carId;
    private Locations pickup;
    private Locations returnPlace;
    private Date pickUpDate;
    private Date returnDate;
    private String name;
    private String lastName;
    private String telephone;
    private String email;
    private String comment;
}
