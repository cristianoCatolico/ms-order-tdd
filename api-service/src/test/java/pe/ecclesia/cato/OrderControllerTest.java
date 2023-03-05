package pe.ecclesia.cato;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pe.ecclesia.cato.api.dto.Order;
import pe.ecclesia.cato.controller.OrderController;
import pe.ecclesia.cato.exception.OrderNotFoundException;
import pe.ecclesia.cato.service.OrderService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OrderController.class)
public class OrderControllerTest {
    private static final String ORDERS_PATH = "/orders";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    OrderService orderService;
    @Test
    public void getAllOrdersTest() throws  Exception{
        List<Order> orders = new ArrayList<>();
        Order orderDTO = new Order();
        orderDTO.setProductId(1L);
        orders.add(orderDTO);
        when(orderService.getAllOrders()).thenReturn(orders);

        this.mockMvc.perform(get(ORDERS_PATH))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[*].productId").value(1));
        ;
    }

    @Test
    public void it_shoudl_Return_Order_NotFound() throws  Exception{
        when(orderService.getOrderByCodeNumber(Mockito.anyString())).thenThrow(new OrderNotFoundException());

        this.mockMvc.perform(get(ORDERS_PATH.concat("/A01")))
                .andExpect(status().isNotFound());
    }
}
