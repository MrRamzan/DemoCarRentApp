package kg.megacom.DemoCarRentApp.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {

    private Long id;
    private Date start;
    private Date end;
    private Boolean ended;
    private double totalSum;
    private LocationDto location;
    private CarDto car;
    private ClientDto client;
    private String comment;
}
