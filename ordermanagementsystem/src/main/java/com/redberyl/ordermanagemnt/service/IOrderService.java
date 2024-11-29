package com.redberyl.ordermanagemnt.service;

import com.redberyl.ordermanagemnt.dto.InvoiceDTO;
import com.redberyl.ordermanagemnt.dto.OrderDTO;
import com.redberyl.ordermanagemnt.dto.UserDTO;

import java.util.List;

public interface IOrderService {
	
    InvoiceDTO createOrderAndGenerateInvoice(List<OrderDTO> orderDTOs, UserDTO user);
}
