package com.curs.cursospring.repositories;

import com.curs.cursospring.entities.OrderItem;
import com.curs.cursospring.entities.User;
import com.curs.cursospring.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}
