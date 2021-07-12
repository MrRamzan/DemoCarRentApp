package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {

    List<Tariff> getAllByEnabled(boolean enabled);
}
