package kg.megacom.DemoCarRentApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "pay_rent", nullable = false)
    private Float payRent;

    @Column(name = "pay_booking", nullable = false)
    private Float payBooking;

    @Column(name = "free_booking_min", nullable = false)
    private int freeBookingMin;

    @Column(name = "enabled", columnDefinition = "boolean default true")
    private Boolean enabled;
}
