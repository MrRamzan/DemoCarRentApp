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
@Table(name = "order_data")
public class OrderData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action")
    private int action;

    @Column(name = "timestampstart")
    private Date start;

    @Column(name = "timestampend")
    private Date end;

    @Column(name = "ended")
    private Boolean ended;

    @Column(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;
}
