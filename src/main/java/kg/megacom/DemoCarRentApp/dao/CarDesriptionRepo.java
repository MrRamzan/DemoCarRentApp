package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.CarDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDesriptionRepo extends JpaRepository<CarDescription, Long> {
}
