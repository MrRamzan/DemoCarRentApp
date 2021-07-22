package kg.megacom.DemoCarRentApp.service;

import kg.megacom.DemoCarRentApp.model.dto.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> getAllCars();

    CarDto getCarById(Long id);

    CarDto saveCar(CarDto carDto);

    int deleteCar(Long id);

    int activateCar(Long id);

    List<CarDto> findBySeatsCount(int seats);

    List<CarDto> findByLuggageVolume(int luggage);

    List<CarDto> findByDoorsCount(int doors);

    List<CarDto> findByTransmission(String transmission);

    CarDto updateCar(Long id, CarDto carDto);

    List<CarDto> findByCategory(String categoryName);

    List<CarDto> orderByCategory();

}
