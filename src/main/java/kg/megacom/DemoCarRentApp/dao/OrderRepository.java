package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query(value = "SELECT * FROM orders o INNER JOIN client cl ON cl.id = o.id_client WHERE cl.email = ?", nativeQuery = true)
    List<Orders> findAllByClient(String email);

    @Query(value = "SELECT * FROM orders o INNER JOIN client cl ON cl.id = o.id_client WHERE cl.email = ?1 and o.ended =?2", nativeQuery = true)
    Orders findByClientAndEnded(String email, boolean ended);

}
