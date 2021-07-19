package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.CarDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDescriptionRepo extends JpaRepository<CarDescription, Long> {
}
