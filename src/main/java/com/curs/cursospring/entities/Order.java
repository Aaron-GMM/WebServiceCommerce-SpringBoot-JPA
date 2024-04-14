package com.curs.cursospring.entities;

import com.curs.cursospring.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_orders")
public class Order implements Serializable {

    private  static final long serialVersionUID = 1L;
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private User Client;
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items  = new HashSet<>();
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private  Payment payment;

    public  Order(){}

    public Order(Long id, Instant moment,OrderStatus orderStatus, User client) {
        this.Id = id;
        this.moment = moment;
        this.Client = client;
        setOrderStatus(orderStatus);
    }

    public OrderStatus getOrderStatus(){return OrderStatus.valueOF(orderStatus);}
    public void setOrderStatus(OrderStatus orderStatus){
        if (orderStatus!=null){
            this.orderStatus = orderStatus.getCode();
        }
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }


    public Double getTotal(){
        double sum  = 0.00;
        for (OrderItem x: items){
            sum += x.getSubTotal();
        }
        return sum;
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
