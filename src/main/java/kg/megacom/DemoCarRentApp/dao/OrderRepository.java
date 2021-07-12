package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Car;
import kg.megacom.DemoCarRentApp.model.Client;
import kg.megacom.DemoCarRentApp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByEnded(boolean ended);
    List<Order> findAllByCar(Car car);
    List<Order> findAllByClient(Client client);
    Order findByClientAndEnded(Client client, boolean ended);

}
