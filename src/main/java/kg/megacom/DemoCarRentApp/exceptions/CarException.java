package kg.megacom.DemoCarRentApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CarException extends RuntimeException{

    public CarException(String message){
        super(message);
    }
}
