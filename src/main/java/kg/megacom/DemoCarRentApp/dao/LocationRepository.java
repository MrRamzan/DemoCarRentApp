package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Locations, Long> {
}
