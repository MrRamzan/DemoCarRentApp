package kg.megacom.DemoCarRentApp.service;

import kg.megacom.DemoCarRentApp.model.dto.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> getAllByRented(boolean rented);

    List<CarDto> getAllCars();

    List<CarDto> getAllByEnabled(boolean enabled);

    CarDto getAndroidCarById(Long id);

    CarDto saveCar(CarDto carDto);

    int deleteCar(Long id);

    List<CarDto> findBySeatsCount(int seats);

    List<CarDto> findByLuggageVolume(int luggage);

    List<CarDto> findByDoorsCount(int doors);

    List<CarDto> findByTransmission(String transmission);

    int activateCar (Long id);

    CarDto updateCar (Long id, CarDto carDto);

}
