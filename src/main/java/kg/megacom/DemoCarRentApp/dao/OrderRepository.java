package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Car;
import kg.megacom.DemoCarRentApp.model.Client;
import kg.megacom.DemoCarRentApp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllByEnded(boolean ended);
    List<Orders> findAllByCar(Car car);
    List<Orders> findAllByClient(Client client);
    Orders findByClientAndEnded(Client client, boolean ended);

}
