package kg.megacom.DemoCarRentApp.controller;

import kg.megacom.DemoCarRentApp.model.android.CarData;
import kg.megacom.DemoCarRentApp.model.dto.OrderDto;
import kg.megacom.DemoCarRentApp.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("getById/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/getAll")
    public List<OrderDto> orderDtos() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getAllByClient")
    public List<OrderDto> getAllByClient(@RequestParam String email) {
        return orderService.getAllByClient(email);
    }

}
