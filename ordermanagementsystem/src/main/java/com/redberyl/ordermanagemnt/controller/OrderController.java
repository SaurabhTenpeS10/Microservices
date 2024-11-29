package com.redberyl.ordermanagemnt.controller;

import com.redberyl.ordermanagemnt.dto.InvoiceDTO;
import com.redberyl.ordermanagemnt.dto.OrderRequestDTO;
import com.redberyl.ordermanagemnt.service.IOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Order Management APIs",
        description = "APIs for creating orders and generating invoices."
)
@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
@Validated
public class OrderController {

    private final IOrderService orderService;

    @Operation(
            summary = "Create Order and Generate Invoice",
            description = "Creates an order from a list of order items and generates an invoice."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Order created and invoice generated successfully",
                    content = @Content(schema = @Schema(implementation = InvoiceDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input, one or more fields failed validation."
            )
    })
    @PostMapping
    public ResponseEntity<InvoiceDTO> createOrder(@RequestBody @Valid OrderRequestDTO request) {
        InvoiceDTO invoice = orderService.createOrderAndGenerateInvoice(request.getOrderDTOs(), request.getUser());
        return ResponseEntity.status(HttpStatus.OK).body(invoice);
    }
    
    

}
