package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Tariff;
import kg.megacom.DemoCarRentApp.model.dto.TariffDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TariffMapper {
    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);

    Tariff toDto(Tariff tariff);

    TariffDto toTariff(TariffDto tariffDto);

    List<Tariff> toDtoList(List<Tariff> tariffList);

    List<TariffDto> toTariffList(List<TariffDto> tariffDtoList);
}
