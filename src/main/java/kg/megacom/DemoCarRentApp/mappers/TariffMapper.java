package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Tariff;
import kg.megacom.DemoCarRentApp.model.dto.TariffDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TariffMapper {
    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);

    TariffDto toDto(Tariff tariff);

    Tariff toTariff(TariffDto tariffDto);

    List<TariffDto> toDtoList(List<Tariff> tariffList);

    List<Tariff> toTariffList(List<TariffDto> tariffDtoList);
}
