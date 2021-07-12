package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
