package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Order;
import kg.megacom.DemoCarRentApp.model.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDataRepository extends JpaRepository<OrderData, Long> {

    List<OrderData> findAllByOrder(Order order);

    OrderData findOrderDataByOrderAndEnded(Order order, boolean ended);
}
