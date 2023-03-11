package pe.ecclesia.cato.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pe.ecclesia.cato.api.dto.ProductDto;
import pe.ecclesia.cato.api.rest.ProductsApi;
import pe.ecclesia.cato.service.ProductService;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class ProductController implements ProductsApi {
    private final ProductService productsService;
    @Override
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productsService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
