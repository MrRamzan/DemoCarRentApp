package kg.megacom.DemoCarRentApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "token")
    private String token;

    @Column(name = "price")
    private Float price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;
}
