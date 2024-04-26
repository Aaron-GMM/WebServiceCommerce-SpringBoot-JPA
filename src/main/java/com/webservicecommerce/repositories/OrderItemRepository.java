package com.webservicecommerce.repositories;

import com.webservicecommerce.entities.OrderItem;
import com.webservicecommerce.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}
