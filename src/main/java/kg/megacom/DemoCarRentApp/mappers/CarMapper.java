package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Car;
import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    Car toCarDto(Car Car);

    CarDto toCar(CarDto carDto);

    List<Car> toCarDtoList(List<Car> carList);

    List<CarDto> toCarList(List<CarDto> carDtoList);
}
