package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.LocationRepository;
import kg.megacom.DemoCarRentApp.exceptions.GeneralException;
import kg.megacom.DemoCarRentApp.mappers.LocationMapper;
import kg.megacom.DemoCarRentApp.model.Locations;
import kg.megacom.DemoCarRentApp.model.dto.LocationDto;
import kg.megacom.DemoCarRentApp.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationDto> getAll() {
        List<Locations> locations = locationRepository.findAll();
        return LocationMapper.INSTANCE.toDtoList(locations);
    }

    @Override
    public LocationDto getById(Long id) {
        Locations locations = locationRepository.findById(id).orElse(null);
        if (locations != null) {
            return LocationMapper.INSTANCE.toDto(locations);
        }
        throw new GeneralException("Location not found");
    }

    @Override
    public LocationDto save(LocationDto locationDto) {
        Locations locations = LocationMapper.INSTANCE.toEntity(locationDto);
        locations = locationRepository.save(locations);
        return LocationMapper.INSTANCE.toDto(locations);
    }

    @Override
    public LocationDto update(Long id, LocationDto locationDto) {
        if (locationRepository.existsById(id)) {
            Locations locations = locationRepository.getById(id);
            locations.setName(locationDto.getName());
            locations = locationRepository.save(locations);
            return LocationMapper.INSTANCE.toDto(locations);
        }
        throw new GeneralException("Location was not updated");
    }

    @Override
    public int delete(Long id) {
        if (locationRepository.existsById(id)) {
            Locations locations = locationRepository.getById(id);
            locationRepository.delete(locations);
            return 1;
        }
        return 0;
    }

}
