package kg.megacom.DemoCarRentApp.controller;

import kg.megacom.DemoCarRentApp.model.dto.CarDescriptionDto;
import kg.megacom.DemoCarRentApp.service.CarDescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/description")
public class CarDescriptionController {

    private CarDescriptionService carDescriptionService;

    public CarDescriptionController(CarDescriptionService carDescriptionService) {
        this.carDescriptionService = carDescriptionService;
    }

    @GetMapping("/getAll")
    public List<CarDescriptionDto> carDescriptionDtos() {
        return carDescriptionService.getAll();
    }

    @GetMapping("getById/{id}")
    public CarDescriptionDto findById(@PathVariable Long id) {
        return carDescriptionService.findById(id);
    }

    @PostMapping("save")
    public CarDescriptionDto saveDescr(@RequestBody CarDescriptionDto carDescriptionDto) {
        return carDescriptionService.save(carDescriptionDto);
    }

    @PutMapping("/update/{id}")
    public CarDescriptionDto update(@PathVariable Long id, @RequestBody CarDescriptionDto carDescriptionDto) {
        return carDescriptionService.update(id, carDescriptionDto);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return carDescriptionService.delete(id);
    }

}
