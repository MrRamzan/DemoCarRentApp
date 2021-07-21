package kg.megacom.DemoCarRentApp.service;

import kg.megacom.DemoCarRentApp.model.android.CarData;
import kg.megacom.DemoCarRentApp.model.dto.ClientDto;
import kg.megacom.DemoCarRentApp.model.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto saveOrder(CarData carData);

    OrderDto update (Long id, CarData carData);

    OrderDto getOrderById(Long id);

    List<OrderDto> getAllOrders();

    List<OrderDto> getAllByEnded(boolean ended);

    List<OrderDto> getAllByClient(String email);

    OrderDto getCurrentOrderByClientID(ClientDto clientDto);

}
