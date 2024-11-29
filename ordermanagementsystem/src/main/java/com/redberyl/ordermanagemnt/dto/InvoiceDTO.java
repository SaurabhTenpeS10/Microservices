package com.redberyl.ordermanagemnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {
    private Long orderId;
    private String orderDate;
    private UserDTO user;
    private List<ItemDTO> items;
    private double totalAmount;
}
