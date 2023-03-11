package pe.ecclesia.cato;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pe.ecclesia.cato.api.dto.ProductDto;
import pe.ecclesia.cato.controller.ProductController;
import pe.ecclesia.cato.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerIT {

    private final String PRODUCTS_PATH = "/products";
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ProductService productService;
    @Test
    @DisplayName("Should return List of products")
    public void when_get_products_return_list() throws Exception{
        List<ProductDto> products = new ArrayList<>();
        ProductDto product = new ProductDto();
        product.setName("colinos");
        products.add(product);
        when(productService.findAll()).thenReturn(products);
        this.mockMvc.perform(get(PRODUCTS_PATH))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[*].name").value("colinos"));
    }
}
