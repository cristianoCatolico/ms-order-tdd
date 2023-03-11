package pe.ecclesia.cato.persistence.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pe.ecclesia.cato.api.dto.OrderDto;
import pe.ecclesia.cato.persistence.entity.OrderEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    @Mapping(source = "order.id", target = "id")
    @Mapping(source = "order.client.id", target = "clientId")
    @Mapping(source = "order.codeNumber", target = "codeNumber")
    OrderDto entityToResponse(OrderEntity order);
}
