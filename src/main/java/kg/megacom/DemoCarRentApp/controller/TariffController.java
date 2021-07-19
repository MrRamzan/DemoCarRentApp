package kg.megacom.DemoCarRentApp.controller;

import kg.megacom.DemoCarRentApp.model.dto.TariffDto;
import kg.megacom.DemoCarRentApp.service.TariffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tariff")
public class TariffController {

    private TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping("/getAll")
    public List<TariffDto> getAll() {
        return tariffService.getAll();
    }

    @GetMapping("/getById/{id}")
    public TariffDto fidnById(@PathVariable Long id) {
        return tariffService.findById(id);
    }

    @PostMapping("/save")
    public TariffDto saveTariff(@RequestBody TariffDto tariffDto) {
        return tariffService.save(tariffDto);
    }

    @PutMapping("/update/{id}")
    public TariffDto updateTariff(@PathVariable Long id, @RequestBody TariffDto tariffDto) {
        return tariffService.update(id, tariffDto);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteTariff(@PathVariable Long id) {
        return tariffService.delete(id);
    }
}
