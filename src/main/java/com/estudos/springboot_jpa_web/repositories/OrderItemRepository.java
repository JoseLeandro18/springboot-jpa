package com.estudos.springboot_jpa_web.repositories;

import com.estudos.springboot_jpa_web.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
