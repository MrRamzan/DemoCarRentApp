package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.OrderRepository;
import kg.megacom.DemoCarRentApp.exceptions.GeneralException;
import kg.megacom.DemoCarRentApp.mappers.CarMapper;
import kg.megacom.DemoCarRentApp.mappers.ClientMapper;
import kg.megacom.DemoCarRentApp.mappers.OrderMapper;
import kg.megacom.DemoCarRentApp.model.Action;
import kg.megacom.DemoCarRentApp.model.Car;
import kg.megacom.DemoCarRentApp.model.Client;
import kg.megacom.DemoCarRentApp.model.Orders;
import kg.megacom.DemoCarRentApp.model.android.CarData;
import kg.megacom.DemoCarRentApp.model.dto.CarDto;
import kg.megacom.DemoCarRentApp.model.dto.ClientDto;
import kg.megacom.DemoCarRentApp.model.dto.OrderDto;
import kg.megacom.DemoCarRentApp.service.CarService;
import kg.megacom.DemoCarRentApp.service.ClientService;
import kg.megacom.DemoCarRentApp.service.OrderService;
import kg.megacom.DemoCarRentApp.service.TariffService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ClientService clientService;
    private CarService carService;
    private TariffService tariffService;

    public OrderServiceImpl(OrderRepository orderRepository, ClientService clientService, CarService carService, TariffService tariffService) {
        this.orderRepository = orderRepository;
        this.clientService = clientService;
        this.carService = carService;
        this.tariffService = tariffService;
    }

    @Override
    public OrderDto saveOrder(CarData carData) {
        CarDto carDto = carService.getCarById(carData.getCarId());
        Car car = CarMapper.INSTANCE.toCar(carDto);
        ClientDto clientDto = clientService.getByMail(carData.getEmail());
        Client client = ClientMapper.INSTANCE.toClient(clientDto);
        if (client == null && car.getAction() != Action.RENT) {
            // создаем нового клиента
            Client client1 = new Client();
            client1.setFirstName(carData.getName());
            client1.setLastName(carData.getLastName());
            client1.setEmail(carData.getEmail());
            client1.setTelephone(carData.getTelephone());
            client1.setActiveStatus(true);
            client1.setRegistrationDate(new Date());
            int randomPass = (int) (Math.random() * 10000);
            String randomPassToString = String.valueOf(randomPass);
            client1.setPassword(randomPassToString);
            ClientDto clientDto1 = clientService.saveClient(ClientMapper.INSTANCE.toClientDto(client1));

            // создаем новый заказ
            Orders orders = new Orders();
            orders.setCar(car);
            orders.setClient(ClientMapper.INSTANCE.toClient(clientDto1));
            orders.setPickUpLocation(carData.getPickup());
            orders.setReturnLocation(carData.getReturnPlace());

            //меняем статус авто на прокат
            car.setAction(Action.RENT);
            carService.updateCar(carData.getCarId(), carDto);
            orders.setComment(carData.getComment());

            orders.setStart(carData.getPickUpDate());
            orders.setEnd(carData.getReturnDate());
            long rentDay = (orders.getEnd().getTime() - orders.getStart().getTime()) / (24 * 60 * 60 * 1000);
            System.out.println(rentDay);
            orders.setTotalSum(car.getTariff().getPrice() * rentDay);

            orders.setEnded(false);
            orders = orderRepository.save(orders);
            return OrderMapper.INSTANCE.toDto(orders);

        } else if (client != null && car.getAction() != Action.RENT) {
            Orders orders = new Orders();
            orders.setCar(car);
            orders.setClient(client);

            orders.setPickUpLocation(carData.getPickup());
            orders.setReturnLocation(carData.getReturnPlace());
            car.setAction(Action.RENT);
            carService.updateCar(carData.getCarId(), CarMapper.INSTANCE.toCarDto(car));

            orders.setStart(carData.getPickUpDate());
            orders.setEnd(carData.getReturnDate());
            long rentDay = (orders.getEnd().getTime() - orders.getStart().getTime()) / (24 * 60 * 60 * 1000);
            System.out.println(rentDay);
            orders.setTotalSum(car.getTariff().getPrice() * rentDay);
            orders.setComment(carData.getComment());
            orders.setEnded(false);
            orders = orderRepository.save(orders);
            return OrderMapper.INSTANCE.toDto(orders);
        }
        throw new GeneralException("ORDERS WAS NOT SAVED, BECAUSE CAR WAS RENTED");
    }

    @Override
    public OrderDto update(Long id, CarData carData) {
        if (orderRepository.existsById(id)) {
            Orders orders = orderRepository.getById(id);
            Car car = CarMapper.INSTANCE.toCar(carService.getCarById(carData.getCarId()));
            Client client = ClientMapper.INSTANCE.toClient(clientService.getByMail(carData.getEmail()));
            orders.setCar(car);
            orders.setClient(client);
            orders.setStart(carData.getPickUpDate());
            orders.setEnd(carData.getReturnDate());
            orders.setPickUpLocation(carData.getPickup());
            orders.setReturnLocation(carData.getReturnPlace());
            orders = orderRepository.save(orders);
            return OrderMapper.INSTANCE.toDto(orders);
        }
        throw new GeneralException("Order with this ID was not found");
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Orders orders = orderRepository.findById(id).orElse(null);
        if (orders == null) {
            throw new GeneralException("Order was not found");
        }
        return OrderMapper.INSTANCE.toDto(orders);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Orders> ordersList = orderRepository.findAll();
        return OrderMapper.INSTANCE.toDtoList(ordersList);
    }

    @Override
    public List<OrderDto> getAllByEnded(boolean ended) {
        List<Orders> orders = orderRepository.findAllByEnded(ended);
        return OrderMapper.INSTANCE.toDtoList(orders);
    }

    @Override
    public List<OrderDto> getAllByClient(String email) {
        List<Orders> orders = orderRepository.findAllByClient(email);
        return OrderMapper.INSTANCE.toDtoList(orders);
    }

    @Override
    public OrderDto findByClientAndEnded(String email, boolean ended) {
        Orders orders = orderRepository.findByClientAndEnded(email, ended);
        return OrderMapper.INSTANCE.toDto(orders);
    }

    //  получение текущего заказа по ID клиента
    @Override
    public OrderDto getCurrentOrderByClientID(Long id) {
        Client client = ClientMapper.INSTANCE.toClient(clientService.getById(id));
        Orders orders = orderRepository.findByClientAndEnded(client.getEmail(), false);
        if (orders != null) {
            return OrderMapper.INSTANCE.toDto(orders);
        }
        return null;
    }

    @Override
    public OrderDto finishOrder(Long id) {
        Orders orders = OrderMapper.INSTANCE.toOrder(getCurrentOrderByClientID(id));
        if (!orders.getEnded()) {
            Car car = orders.getCar();
            car.setAction(Action.AVAILABLE);
            carService.saveCar(CarMapper.INSTANCE.toCarDto(car));

            orders.setEnd(orders.getEnd());
            orders.setEnded(true);
            orders.setReturnLocation(orders.getReturnLocation());
            orders.setPickUpLocation(orders.getPickUpLocation());
            orders.setTotalSum(orders.getTotalSum());
            orderRepository.save(orders);
            return OrderMapper.INSTANCE.toDto(orders);
        }
        return null;
    }


}
