package es.upm.miw.daos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.upm.miw.entities.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

    List<Order> findByAmountGreaterThan(BigDecimal amount);
}
