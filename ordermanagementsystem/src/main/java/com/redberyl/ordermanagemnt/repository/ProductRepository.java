package com.redberyl.ordermanagemnt.repository;

import com.redberyl.ordermanagemnt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
