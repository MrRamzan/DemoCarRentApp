package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM Cars c WHERE c.seats = ?1", nativeQuery = true)
    List<Car> findBySeatsCount(int seats);

    @Query(value = "SELECT * FROM Cars c WHERE c.luggage = ?1", nativeQuery = true)
    List<Car> findByLuggageVolume(int luggage);

    @Query(value = "SELECT * FROM Cars c WHERE c.doors = ?1", nativeQuery = true)
    List<Car> findByDoorsCount(int doors);

    @Query(value = "SELECT * FROM Cars c INNER JOIN car_description cd ON c.id_car_description = cd.id WHERE cd.transmission = ?1", nativeQuery = true)
    List<Car> findByTransmission(String transmission);

    @Query(value = "SELECT * FROM Cars c INNER JOIN category ct ON ct.id = c.id_category WHERE ct.car_category = ?", nativeQuery = true)
    List<Car> findByCarCategory(String carCategory);

    @Query(value = "SELECT * FROM cars cr ORDER BY cr.id_category", nativeQuery = true)
    List<Car> orderByCategory();

}
