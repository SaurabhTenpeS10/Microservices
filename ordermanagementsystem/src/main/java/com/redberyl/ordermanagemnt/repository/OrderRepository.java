package com.redberyl.ordermanagemnt.repository;

import com.redberyl.ordermanagemnt.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
