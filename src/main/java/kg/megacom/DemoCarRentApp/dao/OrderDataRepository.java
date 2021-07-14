package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.OrderData;
import kg.megacom.DemoCarRentApp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDataRepository extends JpaRepository<OrderData, Long> {

    List<OrderData> findAllByOrders(Orders orders);

    OrderData findOrderDataByOrdersAndEnded(Orders orders, boolean ended);
}
