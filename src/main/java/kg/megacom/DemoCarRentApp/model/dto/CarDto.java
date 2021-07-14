package kg.megacom.DemoCarRentApp.model.dto;

import lombok.Data;

@Data
public class CarDto {

    private Long id;
    private CategoryDto category;
    private String year;
    private String model;
    private int doors;
    private int luggage;
    private int seats;
    private CarDescriptionDto carDescription;
    private TariffDto tariff;

}
