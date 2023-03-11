package pe.ecclesia.cato;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pe.ecclesia.cato.persistence.entity.OrderEntity;
import pe.ecclesia.cato.persistence.repository.OrderRepository;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
@DataJpaTest
public class OrderRepositoryIT {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void whenGetAllOrders_ThenReturnList(){
        List<OrderEntity> orders = orderRepository.findOrdersByStatusAndCodeNumber(null,null);
        assertThat(orders.size(), is(3));
    }

}
