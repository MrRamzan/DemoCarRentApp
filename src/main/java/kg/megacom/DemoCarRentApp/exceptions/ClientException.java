package kg.megacom.DemoCarRentApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClientException extends RuntimeException {

    public ClientException(String message) {
        super(message);
    }

}
