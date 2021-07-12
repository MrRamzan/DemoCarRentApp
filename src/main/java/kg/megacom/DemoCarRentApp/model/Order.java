package kg.megacom.DemoCarRentApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestampstart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Column(name = "timestampend")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    @Column(name = "blocked")
    private Boolean blocked;

    @Column(name = "ended")
    private Boolean ended;

    @Transient
    private String bookingTime, rentTime;

    @Transient
    private Float price;

    @ManyToOne
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderData> orderData;

    @OneToOne(mappedBy = "order", fetch = FetchType.EAGER)
    private Payment payment;
}
