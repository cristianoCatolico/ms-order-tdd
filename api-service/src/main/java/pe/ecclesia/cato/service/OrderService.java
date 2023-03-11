package pe.ecclesia.cato.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.ecclesia.cato.api.dto.OrderDto;
import pe.ecclesia.cato.persistence.entity.OrderEntity;
import pe.ecclesia.cato.persistence.mapper.OrderMapper;
import org.springframework.transaction.annotation.Transactional;
import pe.ecclesia.cato.persistence.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    @Transactional(readOnly = true)
    public List<OrderDto> getAllOrders() {
        log.info("Calling getAllOrders");
        List<OrderEntity> activeOrders = orderRepository.findOrdersByStatusAndCodeNumber(null, null);
        return activeOrders.stream().map(order -> orderMapper.entityToResponse(order)).collect(Collectors.toList());
    }

    public OrderDto getOrderByCodeNumber(String anyString) {
        return null;
    }
}
