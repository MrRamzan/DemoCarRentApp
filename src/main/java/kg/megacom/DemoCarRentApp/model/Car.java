package kg.megacom.DemoCarRentApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;
    private Boolean enabled;
    private String comment;
    private Boolean rented;
    private String year;
    private String model;
    private int doors;
    private int luggage;
    private int seats;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_car_description", nullable = false)
    private CarDescription carDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tariff", nullable = false)
    private Tariff tariff;
}
