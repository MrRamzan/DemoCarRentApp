package kg.megacom.DemoCarRentApp.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarSearchRequestModel {

    @JsonProperty(value = "doors")
    private Integer doors;

    @JsonProperty(value = "luggage")
    private Integer luggage;

    @JsonProperty(value = "seats")
    private Integer seats;

    @JsonProperty(value = "transmission")
    private String transmission;

}
