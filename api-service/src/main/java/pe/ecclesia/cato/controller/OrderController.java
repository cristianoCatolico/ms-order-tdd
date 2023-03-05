package pe.ecclesia.cato.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pe.ecclesia.cato.api.dto.Order;
import pe.ecclesia.cato.api.rest.OrdersApi;
import pe.ecclesia.cato.service.OrderService;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@RestController
public class OrderController implements OrdersApi {
    private final OrderService orderService;

    @Override
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> getOrderByCodeNumber(String codeNumber) {
        Order order = orderService.getOrderByCodeNumber(codeNumber);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
