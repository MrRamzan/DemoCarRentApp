package kg.megacom.DemoCarRentApp.controller;

import io.swagger.annotations.Api;
import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import kg.megacom.DemoCarRentApp.model.request.CarSearchRequestModel;
import kg.megacom.DemoCarRentApp.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kg.megacom.DemoCarRentApp.config.Swagger2Config.CAR;

@Api(tags = CAR)
@RestController
@RequestMapping(value = "/api/v1/cars")
public class CarController {

    private static final String ENDPOINT = "/car";
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/save")
    public CarDto saveCar(@RequestBody CarDto carDto) {
        return carService.saveCar(carDto);
    }

    @PutMapping("/update/{id}")
    public CarDto updateCar(@PathVariable Long id, @RequestBody CarDto carDto) {
        return carService.updateCar(id, carDto);
    }

    @PutMapping("/activate/{id}")
    public int activateCar(@PathVariable(value = "id") Long id) {
        return carService.activateCar(id);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteCar(@PathVariable(value = "id") Long id) {
        return carService.deleteCar(id);
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

    @PostMapping("/getByParam")
    public ResponseEntity<List<CarDto>> searchCar(@RequestBody CarSearchRequestModel carSearchRequestModel) {
        List<CarDto> persons = carService.searchCar(carSearchRequestModel);
        return new ResponseEntity<List<CarDto>>(persons, HttpStatus.OK);
    }

}
