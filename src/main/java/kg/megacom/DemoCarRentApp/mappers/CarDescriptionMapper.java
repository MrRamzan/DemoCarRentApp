package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.CarDescription;
import kg.megacom.DemoCarRentApp.model.dto.CarDescriptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarDescriptionMapper {

    CarDescriptionMapper INSTANCE = Mappers.getMapper(CarDescriptionMapper.class);

    CarDescription toCarDescriptDto(CarDescription carDescription);

    CarDescriptionDto toCarDescription(CarDescriptionDto carDescriptionDto);

    List<CarDescription> toCarDescriptDtoList(List<CarDescription> carDescriptionList);

    List<CarDescriptionDto> toCarDescriptionList(List<CarDescriptionDto> carDescriptionDtoList);
}
