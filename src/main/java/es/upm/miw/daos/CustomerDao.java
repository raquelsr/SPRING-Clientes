package es.upm.miw.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import es.upm.miw.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

    List<Customer> findByName(String name);

    @Query("select c from Customer c where c.address = ?1")
    List<Customer> findByAddress(String address);

    @Query("select c.id from Customer c where c.orderList is empty")
    List<Customer> findOrderListIsEmpty();
        
    @Modifying
    @Query(value = "delete from Customer c where c.id = ?1")
    void deleteById(int id);

}
