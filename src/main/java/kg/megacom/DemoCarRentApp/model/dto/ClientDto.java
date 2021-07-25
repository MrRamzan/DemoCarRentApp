package kg.megacom.DemoCarRentApp.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ClientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date registrationDate;
    private String telephone;
    private Boolean activeStatus;

}
