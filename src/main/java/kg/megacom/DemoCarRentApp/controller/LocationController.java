package kg.megacom.DemoCarRentApp.controller;

import io.swagger.annotations.Api;
import kg.megacom.DemoCarRentApp.model.dto.LocationDto;
import kg.megacom.DemoCarRentApp.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kg.megacom.DemoCarRentApp.config.Swagger2Config.LOCATIONS;

@Api(tags = LOCATIONS)
@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("getAll")
    public List<LocationDto> findAll() {
        return locationService.getAll();
    }

    @GetMapping("getById/{id}")
    public LocationDto findById(@PathVariable Long id) {
        return locationService.getById(id);
    }

    @PostMapping("save")
    public LocationDto saveLocation(@RequestBody LocationDto locationDto) {
        return locationService.save(locationDto);
    }

    @PutMapping("update/{id}")
    public LocationDto update(@PathVariable Long id, @RequestBody LocationDto locationDto) {
        return locationService.update(id, locationDto);
    }

    @DeleteMapping("delete/{id}")
    public int delete(@PathVariable Long id) {
        return locationService.delete(id);
    }

}
