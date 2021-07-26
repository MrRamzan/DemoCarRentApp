package kg.megacom.DemoCarRentApp.service;

import kg.megacom.DemoCarRentApp.model.android.Response;
import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import kg.megacom.DemoCarRentApp.model.request.CarSearchRequestModel;

import java.util.List;

public interface CarService {

    List<CarDto> getAllCars();

    CarDto getCarById(Long id);

    CarDto saveCar(CarDto carDto);

    CarDto updateCar(Long id, CarDto carDto);

    Response deleteCar(Long id);

    Response activateCar(Long id);

    List<CarDto> findByCategory(String categoryName);

    List<CarDto> orderByCategory();

    List<CarDto> searchCar(CarSearchRequestModel carSearchRequestModel);

}
