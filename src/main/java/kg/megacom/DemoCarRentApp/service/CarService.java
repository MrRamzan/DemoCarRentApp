package kg.megacom.DemoCarRentApp.service;

import kg.megacom.DemoCarRentApp.model.dto.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> getAllByRented(boolean rented);

    List<CarDto> getAllCars();

    List<CarDto> getAllByEnabled(boolean enabled);

    CarDto getAndroidCarById(Long id);

    CarDto saveCar(CarDto carDto);

    void deleteCar(Long id, CarDto carDto);

    List<CarDto> findBySeatsCount(int seats);

    List<CarDto> findByLuggageVolume(int luggage);

    List<CarDto> findByDoorsCount(int doors);

    List<CarDto> findByTransmission(String transmission);
}
