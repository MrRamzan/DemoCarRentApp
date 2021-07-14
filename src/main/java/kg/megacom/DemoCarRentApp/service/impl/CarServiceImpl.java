package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.CarRepository;
import kg.megacom.DemoCarRentApp.mappers.CarMapper;
import kg.megacom.DemoCarRentApp.model.Car;
import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import kg.megacom.DemoCarRentApp.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDto> getAllByRented(boolean rented) {
        List<Car> cars = carRepository.getAllByRented(rented);
        List<CarDto> carDtos = CarMapper.INSTANCE.toCarDtoList(cars);
        return carDtos;
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> carList = carRepository.findAll();
        System.out.println(carList);
        List<CarDto> carDtoList = CarMapper.INSTANCE.toCarDtoList(carList);
        System.out.println(carDtoList);
        return carDtoList;

    }

    @Override
    public List<CarDto> getAllByEnabled(boolean enabled) {
        List<Car> cars = carRepository.getAllByEnabled(enabled);
        List<CarDto> carDtos = CarMapper.INSTANCE.toCarDtoList(cars);
        return carDtos;
    }

    @Override
    public CarDto getAndroidCarById(Long id) {
        Car car = carRepository.findById(id).orElse(null);
        CarDto carDto = CarMapper.INSTANCE.toCarDto(car);
        return carDto;
    }

    @Override
    public CarDto saveCar(CarDto carDto) {
        Car car = CarMapper.INSTANCE.toCar(carDto);
        car = carRepository.save(car);
        return CarMapper.INSTANCE.toCarDto(car);
    }

    @Override
    public int deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            Car car1 = carRepository.getById(id);
            car1.setEnabled(false);
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
            car1.setEnabled(true);
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
            car1.setModel(car.getModel());
            car1.setCategory(car.getCategory());
            car1.setCarDescription(car.getCarDescription());
            car1.setDoors(car.getDoors());
            car1.setLuggage(car.getLuggage());
            car1.setYear(car.getYear());
            car1.setTariff(car.getTariff());
            car1.setSeats(car.getSeats());
            carRepository.save(car1);
            return CarMapper.INSTANCE.toCarDto(car1);
       }
        throw new RuntimeException("Car not found");
    }

}
