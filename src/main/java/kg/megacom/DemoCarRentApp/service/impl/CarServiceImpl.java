package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.CarRepository;
import kg.megacom.DemoCarRentApp.exceptions.GeneralException;
import kg.megacom.DemoCarRentApp.mappers.CarMapper;
import kg.megacom.DemoCarRentApp.model.Action;
import kg.megacom.DemoCarRentApp.model.Car;
import kg.megacom.DemoCarRentApp.model.android.Response;
import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import kg.megacom.DemoCarRentApp.model.request.CarSearchRequestModel;
import kg.megacom.DemoCarRentApp.service.CarService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private EntityManager entityManager;
    Response response = new Response();

    public CarServiceImpl(CarRepository carRepository, EntityManager entityManager) {
        this.carRepository = carRepository;
        this.entityManager = entityManager;
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
    public Response deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            Car newCar = carRepository.getById(id);
            newCar.setActiveStatus(false);
            carRepository.save(newCar);

            if (newCar.getActiveStatus().equals(true)) {
                response.setCode(1);
                response.setMessage("Автомобиль деактивирован");
                return response;
            }
            response.setCode(0);
            response.setMessage("Автомобиль не был деактивирован");
            return response;
        }
        response.setMessage("Автомобиль не найден");
        return response;
    }

    @Override
    public Response activateCar(Long id) {
        if (carRepository.existsById(id)) {
            Car newCar = carRepository.getById(id);
            newCar.setActiveStatus(true);
            carRepository.save(newCar);

            if (newCar.getActiveStatus().equals(true)) {
                response.setCode(1);
                response.setMessage("Автомобиль активирован");
                return response;
            }
            response.setCode(0);
            response.setMessage("Автомобиль неактивирован");
            return response;
        }
        response.setMessage("Автомобиль не найден");
        return response;
    }

    @Override
    public CarDto updateCar(Long id, CarDto carDto) {
        Car car = CarMapper.INSTANCE.toCar(carDto);
        if (carRepository.existsById(id)) {
            Car newCar = carRepository.getById(id);
            newCar.setAction(car.getAction());
            newCar.setModel(car.getModel());
            newCar.setCategory(car.getCategory());
            newCar.setDoors(car.getDoors());
            newCar.setTariff(car.getTariff());
            newCar.setLuggage(car.getLuggage());
            newCar.setYear(car.getYear());
            newCar.setSeats(car.getSeats());
            carRepository.save(newCar);
            return CarMapper.INSTANCE.toCarDto(newCar);
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

    // Запрос по нескольким параметрам
    @Override
    public List<CarDto> searchCar(CarSearchRequestModel carSearchRequestModel) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> root = criteriaQuery.from(Car.class);

        Integer doors = carSearchRequestModel.getDoors();
        Integer seats = carSearchRequestModel.getSeats();
        Integer luggage = carSearchRequestModel.getLuggage();
        String transmission = carSearchRequestModel.getTransmission();

        //  Добавляем критерии поиска для запроса используя CriteriaBuilder

        List<Predicate> searchCriterias = new ArrayList<>();

        if (doors != null && doors != 0) {
            searchCriterias.add(criteriaBuilder.equal(root.get("doors"), doors));
        }

        if (seats != null && seats != 0) {
            searchCriterias.add(criteriaBuilder.equal(root.get("seats"), seats));
        }

        if (luggage != null && luggage != 0) {
            searchCriterias.add(criteriaBuilder.equal(root.get("luggage"), luggage));
        }

        if (transmission != null && !transmission.isEmpty()) {
            searchCriterias.add(criteriaBuilder.like(root.get("transmission"), "%" + transmission + "%"));
        }

        criteriaQuery.select(root).where(criteriaBuilder.and(searchCriterias.toArray(new Predicate[searchCriterias.size()])));
        return CarMapper.INSTANCE.toCarDtoList(entityManager.createQuery(criteriaQuery).getResultList());
    }

}
