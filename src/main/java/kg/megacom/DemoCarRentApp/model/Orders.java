package kg.megacom.DemoCarRentApp.model;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Column(name = "timestampend")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    @Column(name = "ended")
    private Boolean ended;

    @Column(name = "total_sum")
    private double totalSum;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Locations location;

    @ManyToOne
    @JoinColumn(name = "id_cars", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    private String comment;
}
