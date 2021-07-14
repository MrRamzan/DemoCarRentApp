package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Car;
import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDto toCarDto(Car Car);

    Car toCar(CarDto carDto);

    List<CarDto> toCarDtoList(List<Car> carList);

    List<Car> toCarList(List<CarDto> carDtoList);
}
