package es.upm.miw.daos;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.After;
import org.junit.Before;

import es.upm.miw.entities.Customer;
import es.upm.miw.entities.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class CustomerDaoIT {

    @Autowired
    private CustomerDao customerDao;

    private Customer customer;

    private Customer customer2;

    @Before
    public void before() {
        this.customer = new Customer("Raquel", "Madrid");
        this.customer2 = new Customer("Álvaro", "Fuenlabrada");
        Order order1 = new Order(Calendar.getInstance(), new BigDecimal(2));
        List<Order> orderList1 = new ArrayList<Order>();
        orderList1.add(order1);
        this.customer.setOrders(orderList1);

        this.customerDao.save(this.customer);
        this.customerDao.save(this.customer2);
    }

    @Test
    public void testFindAll() {
        assertEquals(2, this.customerDao.findAll().size());
    }

    @Test
    public void testFindOne() {
        assertEquals(this.customer, this.customerDao.findOne(this.customer.getId()));
    }

    @Test
    public void testFindByName() {
        List<Customer> resultados = new ArrayList<Customer>();
        resultados.add(this.customer);
        assertEquals(resultados, this.customerDao.findByName("Raquel"));
    }

    @Test
    public void testFindByAddress() {
        assertEquals(1, this.customerDao.findByAddress("Fuenlabrada").size());
        assertEquals(0, this.customerDao.findByAddress("Mostoles").size());
    }

    @Test
    public void testFindOrderListIsEmpty() {
        assertEquals(1, this.customerDao.findOrderListIsEmpty().size());
    }

    @Transactional
    @Test
    public void testDeleteById() {
        this.customerDao.deleteById(this.customer2.getId());
        assertEquals(1, this.customerDao.findAll().size());
    }

    @After
    public void deleteAll() {
        this.customerDao.deleteAll();
    }

}
