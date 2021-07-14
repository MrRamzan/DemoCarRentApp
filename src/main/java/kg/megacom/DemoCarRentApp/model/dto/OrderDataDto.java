package kg.megacom.DemoCarRentApp.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDataDto {

    private Long id;
    private int action;
    private Date start;
    private Date end;
    private Boolean ended;
    private Float price;
    private OrderDto order;

}
