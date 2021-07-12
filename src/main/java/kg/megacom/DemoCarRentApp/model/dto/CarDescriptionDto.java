package kg.megacom.DemoCarRentApp.model.dto;

import lombok.Data;

@Data
public class CarDescriptionDto {

    private Long id;
    private String transmission;
    private String fuel;
    private String side;
    private String typeOfDriver;
    private Float fuelConsumption;
}
