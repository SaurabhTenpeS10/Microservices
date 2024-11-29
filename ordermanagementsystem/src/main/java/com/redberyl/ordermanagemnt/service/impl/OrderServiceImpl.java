
package com.redberyl.ordermanagemnt.service.impl;

import com.redberyl.ordermanagemnt.dto.InvoiceDTO;
import com.redberyl.ordermanagemnt.dto.ItemDTO;
import com.redberyl.ordermanagemnt.dto.OrderDTO;
import com.redberyl.ordermanagemnt.dto.UserDTO;
import com.redberyl.ordermanagemnt.model.Order;
import com.redberyl.ordermanagemnt.model.OrderItem;
import com.redberyl.ordermanagemnt.model.Product;
import com.redberyl.ordermanagemnt.repository.OrderRepository;
import com.redberyl.ordermanagemnt.repository.ProductRepository;
import com.redberyl.ordermanagemnt.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public InvoiceDTO createOrderAndGenerateInvoice(List<OrderDTO> orderDTOs, UserDTO user) {
        // Fetch product details for each order
        List<OrderItem> orderItems = orderDTOs.stream()
                .map(dto -> {
                    // Fetch product from database
                    Product product = productRepository.findById(dto.getProductId())
                            .orElseThrow(() -> new RuntimeException("Product not found with ID: " + dto.getProductId()));

                    // Map to OrderItem
                    OrderItem item = new OrderItem();
                    item.setProductId(product.getId());
                    item.setProductName(product.getTitle());
                    item.setPrice(product.getPrice());
                    item.setQuantity(dto.getQuantity());
                    return item;
                })
                .collect(Collectors.toList());

        // Create Order entity
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setOrderItems(orderItems);
        orderRepository.save(order);

        // Calculate total amount
        double totalAmount = orderItems.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();

        // Map OrderItems to ItemDTO
        List<ItemDTO> items = orderItems.stream()
                .map(item -> new ItemDTO(item.getProductName(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        // Create InvoiceDTO
        return new InvoiceDTO(order.getId(), order.getOrderDate().toString(),user, items, totalAmount);
    }
}
