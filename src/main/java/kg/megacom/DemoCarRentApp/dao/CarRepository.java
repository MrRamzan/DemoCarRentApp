package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> getAllByEnabled(boolean enabled);
    List<Car> getAllByRented(boolean rented);

    @Query(value = "SELECT * FROM Car c WHERE c.seats = ?1", nativeQuery = true)
    List<Car> findBySeatsCount(int seats);

    @Query(value = "SELECT * FROM Car c WHERE c.luggage = ?1", nativeQuery = true)
    List<Car> findByLuggageVolume (int luggage);

    @Query(value = "SELECT * FROM Car c WHERE c.doors = ?1", nativeQuery = true)
    List<Car> findByDoorsCount (int doors);
}
