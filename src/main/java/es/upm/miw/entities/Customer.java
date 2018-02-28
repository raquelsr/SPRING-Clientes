package es.upm.miw.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String address;

    private Calendar date;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orderList;

    public Customer() {
        // Empty for tests
    }

    public Customer(String name, String address) {
        super();
        this.name = name;
        this.address = address;
        this.orderList = new ArrayList<Order>();
        this.date = Calendar.getInstance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public List<Order> getOrders() {
        return orderList;
    }

    public void setOrders(List<Order> orders) {
        this.orderList = orders;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", date=" + date + ", orders=" + orderList + "]";
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            return id == ((Customer) obj).id;
        }
    }

}
