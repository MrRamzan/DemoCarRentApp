package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.CarRepository;
import kg.megacom.DemoCarRentApp.exceptions.GeneralException;
import kg.megacom.DemoCarRentApp.mappers.CarMapper;
import kg.megacom.DemoCarRentApp.model.Action;
import kg.megacom.DemoCarRentApp.model.Car;
import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import kg.megacom.DemoCarRentApp.service.CarDescriptionService;
import kg.megacom.DemoCarRentApp.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private CarDescriptionService carDescriptionService;

    public CarServiceImpl(CarRepository carRepository, CarDescriptionService carDescriptionService) {
        this.carRepository = carRepository;
        this.carDescriptionService = carDescriptionService;
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> carList = carRepository.findAll();
        return CarMapper.INSTANCE.toCarDtoList(carList);

    }

    @Override
    public CarDto getCarById(Long id) {
        Car car = carRepository.findById(id).orElse(null);
        if (car != null) {
            return CarMapper.INSTANCE.toCarDto(car);
        }
        throw new GeneralException("There is no such machine");
    }

    @Override
    public CarDto saveCar(CarDto carDto) {
        Car car = CarMapper.INSTANCE.toCar(carDto);
        car.setAction(Action.AVAILABLE);
        car = carRepository.save(car);
        return CarMapper.INSTANCE.toCarDto(car);
    }

    @Override
    public int deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            Car car1 = carRepository.getById(id);
            car1.setActiveStatus(false);
            carRepository.save(car1);
            return 1;
        }
        return 0;
    }

    @Override
    public List<CarDto> findBySeatsCount(int seats) {
        List<Car> carList = carRepository.findBySeatsCount(seats);
        List<CarDto> carDtoList = CarMapper.INSTANCE.toCarDtoList(carList);
        return carDtoList;
    }

    @Override
    public List<CarDto> findByLuggageVolume(int luggage) {
        List<Car> carList = carRepository.findByLuggageVolume(luggage);
        List<CarDto> carDtoList = CarMapper.INSTANCE.toCarDtoList(carList);
        return carDtoList;
    }

    @Override
    public List<CarDto> findByDoorsCount(int doors) {
        List<Car> cars = carRepository.findByDoorsCount(doors);
        List<CarDto> carDtoList = CarMapper.INSTANCE.toCarDtoList(cars);
        return carDtoList;
    }

    @Override
    public List<CarDto> findByTransmission(String transmission) {
        List<Car> cars = carRepository.findByTransmission(transmission);
        List<CarDto> carDtoList = CarMapper.INSTANCE.toCarDtoList(cars);
        return carDtoList;
    }

    @Override
    public int activateCar(Long id) {
        if (carRepository.existsById(id)) {
            Car car1 = carRepository.getById(id);
            car1.setActiveStatus(true);
            carRepository.save(car1);
            return 1;
        }
        return 0;
    }

    @Override
    public CarDto updateCar(Long id, CarDto carDto) {
        Car car = CarMapper.INSTANCE.toCar(carDto);
        if (carRepository.existsById(id)) {
            Car car1 = carRepository.getById(id);
            car1.setAction(car.getAction());
            car1.setModel(car.getModel());
            car1.setCategory(car.getCategory());
            car1.setCarDescription(car.getCarDescription());
            car1.setDoors(car.getDoors());
            car1.setLuggage(car.getLuggage());
            car1.setYear(car.getYear());
            car1.setSeats(car.getSeats());
            carRepository.save(car1);
            return CarMapper.INSTANCE.toCarDto(car1);
        }
        throw new GeneralException("Car not found");
    }

    @Override
    public List<CarDto> findByCategory(String categoryName) {
        List<Car> carList = carRepository.findByCarCategory(categoryName);
        if (carList != null) {
            return CarMapper.INSTANCE.toCarDtoList(carList);
        }
        throw new GeneralException("This category was not found");
    }

    @Override
    public List<CarDto> orderByCategory() {
        List<Car> carList = carRepository.orderByCategory();
        return CarMapper.INSTANCE.toCarDtoList(carList);
    }
}
