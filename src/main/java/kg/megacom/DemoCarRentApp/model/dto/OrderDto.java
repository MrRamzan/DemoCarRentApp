package kg.megacom.DemoCarRentApp.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {

    private Long id;
    private Date start;
    private Date end;
    private Boolean blocked;
    private Boolean ended;
    private CarDto carDto;
    private ClientDto client;
    private List<OrderDataDto> orderData;
    private PaymentDto payment;

}