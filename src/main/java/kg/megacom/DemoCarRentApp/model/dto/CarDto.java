package kg.megacom.DemoCarRentApp.model.dto;

import kg.megacom.DemoCarRentApp.model.Action;
import lombok.Data;

@Data
public class CarDto {

    private Long id;
    private CategoryDto category;
    private Action action;
    private int year;
    private String brand;
    private String model;
    private int doors;
    private int luggage;
    private int seats;
    private String transmission;
    private String fuel;
    private String side;
    private String typeOfDriver;
    private Float fuelConsumption;
    private Boolean activeStatus;
    private TariffDto tariff;

}
