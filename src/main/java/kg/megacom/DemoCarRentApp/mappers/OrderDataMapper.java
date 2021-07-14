package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.OrderData;
import kg.megacom.DemoCarRentApp.model.dto.OrderDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDataMapper {

    OrderDataMapper INSTENCE = Mappers.getMapper(OrderDataMapper.class);

    OrderDataDto toDto(OrderData orderData);

    OrderData toOrderData(OrderDataDto orderDataDto);

    List<OrderDataDto> toDtoList(List<OrderData> orderDataList);

    List<OrderData> toOrderDataList(List<OrderDataDto> orderDataDtoList);
}
