package kg.megacom.DemoCarRentApp.controller;

import io.swagger.annotations.Api;
import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import kg.megacom.DemoCarRentApp.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kg.megacom.DemoCarRentApp.config.Swagger2Config.CAR;

@Api(tags = CAR)
@RestController
@RequestMapping(value = "/api/v1/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/findAll")
    public List<CarDto> findAll() {
        return carService.getAllCars();
    }

    @GetMapping("/orderByCategory")
    public List<CarDto> carDtoList() {
        return carService.orderByCategory();
    }

    @GetMapping("/getById/{id}")
    public CarDto findById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/getByCategory")
    public List<CarDto> getByCategory(@RequestParam String categoryName) {
        return carService.findByCategory(categoryName);
    }

    @PostMapping("/save")
    public CarDto saveCar(@RequestBody CarDto carDto) {
        return carService.saveCar(carDto);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteCar(@PathVariable(value = "id") Long id) {
        return carService.deleteCar(id);
    }

    @GetMapping("/getBySeatsCount")
    public List<CarDto> carDtos(@RequestParam int seats) {
        return carService.findBySeatsCount(seats);
    }

    @GetMapping("/getByLuggage")
    public List<CarDto> getBYLuggageVolume(@RequestParam int luggage) {
        return carService.findByLuggageVolume(luggage);
    }

    @GetMapping("/getByDoorsCount")
    public List<CarDto> getByDoors(@RequestParam int doors) {
        return carService.findByDoorsCount(doors);
    }

    @GetMapping("/getByTransmission")
    public List<CarDto> getByTransmission(@RequestParam String transmission) {
        return carService.findByTransmission(transmission);
    }

    @PutMapping("/activateCar/{id}")
    public int activateCar(@PathVariable(value = "id") Long id) {
        return carService.activateCar(id);
    }

    @PutMapping("/update/{id}")
    public CarDto updateCar(@PathVariable Long id, @RequestBody CarDto carDto) {
        return carService.updateCar(id, carDto);
    }
}
