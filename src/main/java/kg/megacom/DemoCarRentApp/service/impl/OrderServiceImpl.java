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
import kg.megacom.DemoCarRentApp.model.dto.TariffDto;
import kg.megacom.DemoCarRentApp.service.CarService;
import kg.megacom.DemoCarRentApp.service.ClientService;
import kg.megacom.DemoCarRentApp.service.OrderService;
import kg.megacom.DemoCarRentApp.service.TariffService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        System.out.println(client);
        if (client == null) {
            Client client1 = new Client();
            client1.setFirstname(carData.getName());
            client1.setLastname(carData.getLastName());
            client1.setEmail(carData.getEmail());
            client1.setTelephone(carData.getTelephone());
            client1.setActiveStatus(true);
            client1.setRegistrationDate(new Date());
            int rd = (int) (Math.random() * 10000);
            String random = String.valueOf(rd);
            client1.setPassword(random);
            ClientDto clientDto1 = clientService.saveClient(ClientMapper.INSTANCE.toClientDto(client1));
            System.out.println("save " + clientDto1);
            Orders orders = new Orders();
            orders.setCar(car);
            orders.setClient(ClientMapper.INSTANCE.toClient(clientDto1));
            orders.setLocation(carData.getPickup());
            orders.setLocation(carData.getReturnPlace());
            orders.getCar().setAction(Action.RENT);
            orders.setComment(carData.getComment());

            //  ******************* Parse Date *****************

            try {
                SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

                //Setting dates
                orders.setStart(new Date());
                orders.setEnd(carData.getReturnDate());

                String CurrentDate = dates.format(orders.getStart().getTime());
                String FinalDate = dates.format(orders.getEnd().getTime());

                Date date1 = dates.parse(CurrentDate);
                Date date2 = dates.parse(FinalDate);

                //Comparing dates
                long difference = Math.abs(date1.getTime() - date2.getTime());
                long differenceDates = difference / (24 * 60 * 60 * 1000);
                orders.setTotalSum(car.getTariff().getPrice() * differenceDates);
                System.out.println(differenceDates);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            orders.setEnded(false);
            orders = orderRepository.save(orders);
            return OrderMapper.INSTANCE.toDto(orders);
        } else {
            Orders orders = new Orders();
            orders.setCar(car);
            orders.setClient(client);

            //  ******************* Parse Date *****************

            try {
                SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

                //Setting dates
                orders.setStart(new Date());
                orders.setEnd(carData.getReturnDate());

                String CurrentDate = dates.format(orders.getStart().getTime());
                String FinalDate = dates.format(orders.getEnd().getTime());

                Date date1 = dates.parse(CurrentDate);
                Date date2 = dates.parse(FinalDate);

                //Comparing dates
                long difference = Math.abs(date1.getTime() - date2.getTime());
                long differenceDates = difference / (24 * 60 * 60 * 1000);
                orders.setTotalSum(car.getTariff().getPrice() * differenceDates);
                System.out.println(differenceDates);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            orders.setLocation(carData.getPickup());
            orders.setLocation(carData.getReturnPlace());
            orders.getCar().setAction(Action.RENT);
            orders.setComment(carData.getComment());
            orders.setEnded(false);
            orders = orderRepository.save(orders);
            return OrderMapper.INSTANCE.toDto(orders);
        }
    }

    @Override
    public OrderDto update(Long id, CarData carData) {
        if (orderRepository.existsById(id)) {
            Orders orders = orderRepository.getById(id);
            Car car = CarMapper.INSTANCE.toCar(carService.getCarById(carData.getCarId()));
            Client client = ClientMapper.INSTANCE.toClient(clientService.getByMail(carData.getEmail()));
            orders.setCar(car);
            orders.setClient(client);
            orders.setComment(carData.getComment());
            orders.setStart(carData.getPickUpDate());
            orders.setEnd(carData.getReturnDate());
            orders.setLocation(carData.getPickup());
            orders.setLocation(carData.getReturnPlace());
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
    public OrderDto getCurrentOrderByClientID(ClientDto clientDto) {
        Client client = ClientMapper.INSTANCE.toClient(clientService.getById(clientDto.getId()));
        Orders orders = orderRepository.findByClientAndEnded(client.getEmail(), false);
        if (orders != null) {
            return OrderMapper.INSTANCE.toDto(orders);
        }
        return null;
    }

}
