package kg.megacom.DemoCarRentApp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Action action;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    private int year;
    private String model;
    private int doors;
    private int luggage;
    private int seats;
    private Boolean activeStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_car_description", nullable = false)
    private CarDescription carDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tariff", nullable = false)
    private Tariff tariff;
}
