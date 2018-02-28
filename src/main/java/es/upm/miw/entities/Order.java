package es.upm.miw.entities;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private int id;
    
    @Temporal(TemporalType.DATE)
    private Calendar date;
    
    private BigDecimal amount;

    public Order() {
        //Empty for test
    }
    
    public Order(Calendar date, BigDecimal amount) {
        this.date = date;
        this.amount = amount;
    }
    
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Order [id=" + id + ", date=" + date + ", amount=" + amount + "]";
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
            return id == ((Order) obj).id;
        }
    }

    
}
