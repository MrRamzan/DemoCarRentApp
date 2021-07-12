package kg.megacom.DemoCarRentApp.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentDto {

    private Long id;
    private Date date;
    private Float price;
    private OrderDto orderDto;
}
