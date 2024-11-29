package com.redberyl.ordermanagemnt.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Entity
@Table(name = "products")
@Data
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the product", example = "1")
    private Long id;

    @Schema(description = "Title of the product", example = "Wireless Mouse")
    @NotEmpty(message = "Title cannot be null or empty")
    private String title;

    @Schema(description = "Category of the product", example = "Electronics")
    @NotEmpty(message = "Category cannot be null or empty")
    @Column(nullable = false)
    private String category;

    @Schema(description = "Description of the product", example = "A wireless mouse with ergonomic design and long battery life")
    @Column(columnDefinition = "TEXT")
    private String description;

    @Schema(description = "Price of the product", example = "49.99")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Column(nullable = false)
    private double price;
    
    
}
