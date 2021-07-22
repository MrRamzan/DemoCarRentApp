package kg.megacom.DemoCarRentApp.controller;

import io.swagger.annotations.Api;
import kg.megacom.DemoCarRentApp.model.android.CarData;
import kg.megacom.DemoCarRentApp.model.dto.OrderDto;
import kg.megacom.DemoCarRentApp.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kg.megacom.DemoCarRentApp.config.Swagger2Config.ORDERS;

@Api(tags = ORDERS)
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public OrderDto saveOrder(@RequestBody CarData carData) {
        return orderService.saveOrder(carData);
    }

    @GetMapping("getOrderById/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/getAll")
    public List<OrderDto> orderDtos() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getAllOrderByClient")
    public List<OrderDto> getAllByClient(@RequestParam String email) {
        return orderService.getAllByClient(email);
    }

    @GetMapping("/getCurrentOrderByClientID/{id}")
    public OrderDto getCurrentOrderByClientID(@PathVariable Long id) {
        return orderService.getCurrentOrderByClientID(id);
    }

    @PutMapping("/finishOrder/{id}")
    public OrderDto finishOrder(@PathVariable Long id) {
        return orderService.finishOrder(id);
    }
}
