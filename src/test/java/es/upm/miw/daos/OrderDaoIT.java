package es.upm.miw.daos;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import es.upm.miw.entities.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class OrderDaoIT {

    @Autowired
    private OrderDao orderDao;

    private Order order1;

    private Order order2;

    @Before
    public void before() {
        this.order1 = new Order(Calendar.getInstance(), new BigDecimal(2));
        this.order2 = new Order(Calendar.getInstance(), new BigDecimal(7));

        this.orderDao.save(this.order1);
        this.orderDao.save(this.order2);
    }

    @Test
    public void testFindAll() {
        assertEquals(2, this.orderDao.findAll().size());
    }

    @Test
    public void testFindOne() {
        assertEquals(this.order1, this.orderDao.findOne(3));
    }

    @Test
    public void testFindByAmountGreaterThan() {
        assertEquals(1, this.orderDao.findByAmountGreaterThan(new BigDecimal(3)).size());
    }

    @After
    public void deleteAll() {
        this.orderDao.deleteAll();
    }
}
