package com.redberyl.ordermanagemnt.controller;

import com.redberyl.ordermanagemnt.model.Cart;
import com.redberyl.ordermanagemnt.model.Product;
import com.redberyl.ordermanagemnt.service.ICartService;
import com.redberyl.ordermanagemnt.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Cart Management APIs",
        description = "APIs for managing the cart, including adding products and generating invoices."
)
@RestController
@RequestMapping("/api/cart")
@AllArgsConstructor
public class CartController {

    private final IProductService iProductService;
    private final ICartService iCartService;

    @Operation(
            summary = "Get All Products",
            description = "Retrieve a list of all available products."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Products retrieved successfully",
                    content = @Content(schema = @Schema(implementation = Product.class))
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "No products found"
            )
    })
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = iProductService.getAllProducts();
        if (!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Operation(
            summary = "Add Products to Cart",
            description = "Add multiple products to the cart by providing a list of product IDs."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Products added to cart successfully",
                    content = @Content(schema = @Schema(implementation = Cart.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input, product IDs list is empty"
            )
    })
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(
            @RequestBody 
            @Valid 
            @NotEmpty(message = "Product IDs list cannot be empty") List<Long> productIds) {
        Cart cart = iCartService.addProductsToCart(productIds);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @Operation(
            summary = "Generate Invoice",
            description = "Generate an invoice for the items currently in the cart."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Invoice generated successfully",
                    content = @Content(schema = @Schema(type = "string"))
            )
    })
    @GetMapping("/invoice")
    public ResponseEntity<String> generateInvoice() {
        String invoice = iCartService.generateInvoice();
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }
}
