package kg.megacom.DemoCarRentApp.model.android;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClientReg {

    private String firstname;
    private String secondname;
    private String middlename;
    private String email;
    private String telephone;
    private String password;

}
