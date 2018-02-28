package es.upm.miw.daos;
import org.springframework.data.jpa.repository.JpaRepository;

import es.upm.miw.entities.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

}
