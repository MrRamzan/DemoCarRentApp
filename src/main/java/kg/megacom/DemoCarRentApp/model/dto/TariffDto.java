package kg.megacom.DemoCarRentApp.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TariffDto {

    private Long id;
    private double price;
    private Date priceStart;
    private Date priceEnd;
}
