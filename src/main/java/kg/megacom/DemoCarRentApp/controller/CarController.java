package kg.megacom.DemoCarRentApp.controller;

import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import kg.megacom.DemoCarRentApp.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/findAll")
    public List<CarDto> findAll() {
        return carService.getAllCars();
    }

    @GetMapping("/getRented")
    public List<CarDto> getAllRented(@RequestParam boolean rented) {
        return carService.getAllByRented(rented);
    }

    @GetMapping("/getEnabled")
    public List<CarDto> getAllByEnabled(@RequestParam boolean enabled) {
        return carService.getAllByEnabled(enabled);
    }

    @GetMapping("/getById/{id}")
    public CarDto getById(@PathVariable Long id) {
        return carService.getAndroidCarById(id);
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
    public List<CarDto> getByTransmission (@RequestParam String transmission) {
        return carService.findByTransmission(transmission);
    }

    @PutMapping("/activateCar/{id}")
    public int activateCar (@PathVariable(value = "id") Long id){
        return carService.activateCar(id);
    }

    @PutMapping("/update/{id}")
    public CarDto updateCar (@PathVariable Long id, @RequestBody CarDto carDto){
        return carService.updateCar(id, carDto);
    }
}
