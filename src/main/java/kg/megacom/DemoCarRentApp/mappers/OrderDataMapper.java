package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.OrderData;
import kg.megacom.DemoCarRentApp.model.dto.OrderDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDataMapper {

    OrderDataMapper INSTENCE = Mappers.getMapper(OrderDataMapper.class);

    OrderData toDto(OrderData orderData);

    OrderDataDto toOrderData(OrderDataDto orderDataDto);

    List<OrderData> toDtoList(List<OrderData> orderDataList);

    List<OrderDataDto> toOrderDataList(List<OrderDataDto> orderDataDtoList);
}
