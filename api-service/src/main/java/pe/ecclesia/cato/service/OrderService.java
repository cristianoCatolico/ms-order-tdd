package pe.ecclesia.cato.service;

import org.springframework.stereotype.Service;
import pe.ecclesia.cato.api.dto.Order;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    public List<Order> getAllOrders() {
        return new ArrayList<>();
    }

    public Order getOrderByCodeNumber(String anyString) {
        return null;
    }
}
