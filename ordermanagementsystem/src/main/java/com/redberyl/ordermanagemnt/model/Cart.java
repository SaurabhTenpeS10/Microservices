package com.redberyl.ordermanagemnt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @NotEmpty(message = "Cart must have at least one product")
    private List<Product> products = new ArrayList<>();

    @DecimalMin(value = "0.0", inclusive = true, message = "Total price cannot be negative")
    private double totalPrice;

    /**
     * Calculates the total price of products in the cart.
     * Ensures a valid total price is always computed.
     */
    public void calculateTotalPrice() {
        totalPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
