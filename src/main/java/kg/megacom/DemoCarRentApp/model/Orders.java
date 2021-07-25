package kg.megacom.DemoCarRentApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestampstart")
    @JsonFormat(pattern = "dd.MM.yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Column(name = "timestampend")
    @JsonFormat(pattern = "dd.MM.yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    private Boolean ended;
    private double totalSum;

    @ManyToOne
    @JoinColumn(name = "id_locationPickUp")
    private Locations pickUpLocation;

    @ManyToOne
    @JoinColumn(name = "id_locationReturn")
    private Locations returnLocation;

    @ManyToOne
    @JoinColumn(name = "id_cars", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    private String comment;
}
