package es.upm.miw.daos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.upm.miw.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

    List<Customer> findByName (String name);
}
