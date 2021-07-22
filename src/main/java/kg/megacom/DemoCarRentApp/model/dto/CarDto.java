package kg.megacom.DemoCarRentApp.model.dto;

import kg.megacom.DemoCarRentApp.model.Action;
import lombok.Data;

@Data
public class CarDto {

    private Long id;
    private CategoryDto category;
    private Action action;
    private String year;
    private String model;
    private int doors;
    private int luggage;
    private int seats;
    private Boolean activeStatus;
    private CarDescriptionDto carDescription;
    private TariffDto tariff;

}
