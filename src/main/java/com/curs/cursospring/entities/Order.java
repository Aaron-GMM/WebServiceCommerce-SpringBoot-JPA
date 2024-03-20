package com.curs.cursospring.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
@Entity
@Table(name = "tb_orders")
public class Order implements Serializable {

    private  static final long serialVersionUID = 1L;
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Instant moment;

@ManyToOne
@JoinColumn(name = "clienID")
    private User Client;

public  Order(){

}

    public Order(Long id, Instant moment, User client) {
        Id = id;
        this.moment = moment;
        Client = client;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return Client;
    }

    public void setClient(User client) {
        Client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(Id, order.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
