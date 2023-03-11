package pe.ecclesia.cato.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.ecclesia.cato.persistence.entity.ClientEntity;
import pe.ecclesia.cato.persistence.entity.OrderEntity;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("from OrderEntity where ((:status is null) or (status = :status)) and ((:code is null) or (codeNumber like %:code%))")
    List<OrderEntity> findOrdersByStatusAndCodeNumber(@Param("code") String codeNumber, @Param("status") String status);
    OrderEntity findByClient(ClientEntity client);
}
