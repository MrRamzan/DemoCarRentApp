package kg.megacom.DemoCarRentApp.model.dto;

import lombok.Data;

@Data
public class TariffDto {

    private Long id;
    private String name;
    private Float payRent;
    private Float payBooking;
    private int freeBookingMin;
    private Boolean enabled;
}
