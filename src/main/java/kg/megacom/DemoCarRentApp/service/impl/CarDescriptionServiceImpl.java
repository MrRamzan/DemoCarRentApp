package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.CarDescriptionRepo;
import kg.megacom.DemoCarRentApp.exceptions.GeneralException;
import kg.megacom.DemoCarRentApp.mappers.CarDescriptionMapper;
import kg.megacom.DemoCarRentApp.model.CarDescription;
import kg.megacom.DemoCarRentApp.model.dto.CarDescriptionDto;
import kg.megacom.DemoCarRentApp.service.CarDescriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDescriptionServiceImpl implements CarDescriptionService {

    private CarDescriptionRepo carDescriptionRepo;

    public CarDescriptionServiceImpl(CarDescriptionRepo carDescriptionRepo) {
        this.carDescriptionRepo = carDescriptionRepo;
    }

    @Override
    public CarDescriptionDto findById(Long id) {
        CarDescription carDescription = carDescriptionRepo.findById(id).orElse(null);
        if (carDescription != null) {
            return CarDescriptionMapper.INSTANCE.toCarDescriptDto(carDescription);
        }
        throw new GeneralException("Not found");
    }

    @Override
    public CarDescriptionDto save(CarDescriptionDto carDescriptionDto) {
        CarDescription carDescription = CarDescriptionMapper.INSTANCE.toCarDescription(carDescriptionDto);
        carDescription = carDescriptionRepo.save(carDescription);
        return CarDescriptionMapper.INSTANCE.toCarDescriptDto(carDescription);
    }

    @Override
    public CarDescriptionDto update(Long id, CarDescriptionDto carDescriptionDto) {
        CarDescription carDescription = CarDescriptionMapper.INSTANCE.toCarDescription(carDescriptionDto);
        if (carDescription != null) {
            CarDescription carDescription1 = carDescriptionRepo.getById(id);
            carDescription1.setFuel(carDescription.getFuel());
            carDescription1.setTypeOfDriver(carDescription.getTypeOfDriver());
            carDescription1.setTransmission(carDescription.getTransmission());
            carDescription1.setSide(carDescription.getSide());
            carDescription1.setFuelConsumption(carDescription.getFuelConsumption());
            carDescription1 = carDescriptionRepo.save(carDescription1);
            return CarDescriptionMapper.INSTANCE.toCarDescriptDto(carDescription1);
        }
        throw new GeneralException("The car description has not been updated");
    }

    @Override
    public int delete(Long id) {
        if (carDescriptionRepo.existsById(id)) {
            CarDescription carDescription = carDescriptionRepo.getById(id);
            carDescriptionRepo.delete(carDescription);
            return 1;
        }
        return 0;
    }

    @Override
    public List<CarDescriptionDto> getAll() {
        List<CarDescription> carDescription = carDescriptionRepo.findAll();
        return CarDescriptionMapper.INSTANCE.toCarDescriptDtoList(carDescription);
    }
}
