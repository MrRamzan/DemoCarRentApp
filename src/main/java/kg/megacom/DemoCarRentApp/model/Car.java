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
    private String brand;
    private String model;
    private int doors;
    private int luggage;
    private int seats;
    private String transmission;
    private String fuel;
    private String side;
    private String typeOfDriver;
    private Float fuelConsumption;

    private Boolean activeStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tariff", nullable = false)
    private Tariff tariff;
}
