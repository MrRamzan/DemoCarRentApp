package kg.megacom.DemoCarRentApp.service;

import kg.megacom.DemoCarRentApp.model.dto.CarDescriptionDto;

import java.util.List;

public interface CarDescriptionService {

    CarDescriptionDto findById(Long id);

    CarDescriptionDto save(CarDescriptionDto carDescriptionDto);

    CarDescriptionDto update(Long id, CarDescriptionDto carDescriptionDto);

    int delete(Long id);

    List<CarDescriptionDto> getAll();
}
