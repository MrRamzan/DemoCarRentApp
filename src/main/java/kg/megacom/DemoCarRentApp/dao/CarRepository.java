package kg.megacom.DemoCarRentApp.dao;

import kg.megacom.DemoCarRentApp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM Cars c INNER JOIN category ct ON ct.id = c.id_category WHERE ct.category = ?", nativeQuery = true)
    List<Car> findByCarCategory(String category);

    @Query(value = "SELECT * FROM cars cr ORDER BY cr.id_category", nativeQuery = true)
    List<Car> orderByCategory();

}
