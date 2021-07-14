package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Orders;
import kg.megacom.DemoCarRentApp.model.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto toDto(Orders order);

    Orders toOrder(OrderDto orderDto);

    List<OrderDto> toDtoList(List<Orders> orderList);

    List<Orders> toOrderList(List<OrderDto> orderDtoList);
}
