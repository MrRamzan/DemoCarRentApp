package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.CarDescription;
import kg.megacom.DemoCarRentApp.model.dto.CarDescriptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarDescriptionMapper {

    CarDescriptionMapper INSTANCE = Mappers.getMapper(CarDescriptionMapper.class);

    CarDescriptionDto toCarDescriptDto(CarDescription carDescription);

    CarDescription toCarDescription(CarDescriptionDto carDescriptionDto);

    List<CarDescriptionDto> toCarDescriptDtoList(List<CarDescription> carDescriptionList);

    List<CarDescription> toCarDescriptionList(List<CarDescriptionDto> carDescriptionDtoList);
}
