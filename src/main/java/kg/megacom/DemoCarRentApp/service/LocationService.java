package kg.megacom.DemoCarRentApp.service;

import kg.megacom.DemoCarRentApp.model.dto.LocationDto;

import java.util.List;

public interface LocationService {

    List<LocationDto> getAll();

    LocationDto getById(Long id);

    LocationDto save(LocationDto locationDto);

    LocationDto update(Long id, LocationDto locationDto);

    int delete(Long id);

}
