package com.redberyl.ordermanagemnt.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {

    @NotEmpty(message = "Order items list cannot be empty")
    @Valid
    private List<OrderDTO> orderDTOs;

    @NotNull(message = "User details cannot be null")
    @Valid
    private UserDTO user;

}
