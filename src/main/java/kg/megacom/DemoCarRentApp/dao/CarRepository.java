package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

//    @Query(value = "SELECT * FROM Cars c WHERE c.seats = ?1", nativeQuery = true)
//    List<Car> findBySeatsCount(int seats);
//
//    @Query(value = "SELECT * FROM Cars c WHERE c.luggage = ?1", nativeQuery = true)
//    List<Car> findByLuggageVolume(int luggage);
//
//    @Query(value = "SELECT * FROM Cars c WHERE c.doors = ?1", nativeQuery = true)
//    List<Car> findByDoorsCount(int doors);
//
//    @Query(value = "SELECT * FROM Cars c WHERE c.transmission = ?1", nativeQuery = true)
//    List<Car> findByTransmission(String transmission);

    @Query(value = "SELECT * FROM Cars c INNER JOIN category ct ON ct.id = c.id_category WHERE ct.category = ?", nativeQuery = true)
    List<Car> findByCarCategory(String category);

    @Query(value = "SELECT * FROM cars cr ORDER BY cr.id_category", nativeQuery = true)
    List<Car> orderByCategory();

//    @Query(value = "SELECT * FROM Car cr INNER JOIN category ct ON ct.id = cr.id_category WHERE ct.car_category = ?1 OR ct.car_category is  and cr.seats = ?2 and cr.luggage = ?3 and cr.doors = ?4 and cr.transmission = ?5", nativeQuery = true)
//    List<Car> findByMultipleParameters (String carCategory, int seats, int luggage, int doors, String transmission);


}
