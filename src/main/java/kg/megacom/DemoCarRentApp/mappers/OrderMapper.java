package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Order;
import kg.megacom.DemoCarRentApp.model.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toDto(Order order);

    OrderDto toOrder(OrderDto orderDto);

    List<Order> toDtoList(List<Order> orderList);

    List<OrderDto> toOrderList(List<OrderDto> orderDtoList);
}
