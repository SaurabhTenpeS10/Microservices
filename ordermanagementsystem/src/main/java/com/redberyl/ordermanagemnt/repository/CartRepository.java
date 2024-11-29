package com.redberyl.ordermanagemnt.repository;

import com.redberyl.ordermanagemnt.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
