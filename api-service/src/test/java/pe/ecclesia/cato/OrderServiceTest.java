package pe.ecclesia.cato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.ecclesia.cato.persistence.entity.ClientEntity;
import pe.ecclesia.cato.persistence.entity.OrderEntity;
import pe.ecclesia.cato.persistence.mapper.OrderMapper;
import pe.ecclesia.cato.persistence.repository.OrderRepository;
import pe.ecclesia.cato.service.OrderService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    private OrderService orderService;
    private OrderMapper mapper = Mappers.getMapper(OrderMapper.class);
    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    public void setUp(){
        orderService = new OrderService(orderRepository,mapper);
        OrderEntity orderEntity = OrderEntity.builder()
                        .id(1L)
                        .codeNumber("C01")
                        .status("CREATED")
                        .client(ClientEntity.builder().id(1L).name("catolico").build())
                        .build();
        List<OrderEntity> orders = List.of(orderEntity);
        when(this.orderRepository.findOrdersByStatusAndCodeNumber(null,null)).thenReturn(orders);
    }

    @Test
    public void whenGetAll_ThenReturnAllProducts(){
        assertThat(this.orderService.getAllOrders().size(), is(1));
    }
}
