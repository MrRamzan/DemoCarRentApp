package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Locations;
import kg.megacom.DemoCarRentApp.model.dto.LocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    LocationDto toDto(Locations location);

    Locations toEntity(LocationDto locationDto);

    List<LocationDto> toDtoList(List<Locations> locationList);

    List<Locations> toEntityList(List<LocationDto> locationDtoList);

}
