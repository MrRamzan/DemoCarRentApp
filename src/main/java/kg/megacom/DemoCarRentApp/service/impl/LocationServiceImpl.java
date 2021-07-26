package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.LocationRepository;
import kg.megacom.DemoCarRentApp.exceptions.GeneralException;
import kg.megacom.DemoCarRentApp.mappers.LocationMapper;
import kg.megacom.DemoCarRentApp.model.Locations;
import kg.megacom.DemoCarRentApp.model.android.Response;
import kg.megacom.DemoCarRentApp.model.dto.LocationDto;
import kg.megacom.DemoCarRentApp.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;
    Response response = new Response();

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
        locations.setActive(true);
        locationRepository.save(locations);
        return LocationMapper.INSTANCE.toDto(locations);
    }

    @Override
    public LocationDto update(Long id, LocationDto locationDto) {
        if (locationRepository.existsById(id)) {
            Locations locations = locationRepository.getById(id);
            locations.setName(locationDto.getName());
            locationRepository.save(locations);
            return LocationMapper.INSTANCE.toDto(locations);
        }
        throw new GeneralException("Location was not updated");
    }

    @Override
    public Response delete(Long id) {
        if (locationRepository.existsById(id)) {
            Locations locations = locationRepository.getById(id);
            locations.setActive(false);
            locationRepository.save(locations);

            //  Добавляем вывод сообщения на экран
            response.setCode(1);
            response.setMessage("Локация успешно деактивирована");
            return response;
        }
        response.setCode(0);
        response.setMessage("Локация не найдена");
        return response;
    }

    @Override
    public Response activate(Long id) {
        if (locationRepository.existsById(id)) {
            Locations locations = locationRepository.getById(id);
            locations.setActive(true);
            locationRepository.save(locations);
            if (locations.isActive()) {
                response.setCode(1);
                response.setMessage("Локация активирована");
                return response;
            }
            response.setCode(0);
            response.setMessage("Локация не активирована");
        }
        response.setMessage("Локация с таким ID  не найдена");
        return response;
    }

}
