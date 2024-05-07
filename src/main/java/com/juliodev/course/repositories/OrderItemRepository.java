package com.juliodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliodev.course.entities.OrderItem;
import com.juliodev.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
