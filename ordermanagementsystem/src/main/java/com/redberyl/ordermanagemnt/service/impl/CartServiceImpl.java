package com.redberyl.ordermanagemnt.service.impl;

import com.redberyl.ordermanagemnt.exception.ResourceNotFoundException;
import com.redberyl.ordermanagemnt.model.Cart;
import com.redberyl.ordermanagemnt.model.Product;
import com.redberyl.ordermanagemnt.repository.CartRepository;
import com.redberyl.ordermanagemnt.repository.ProductRepository;
import com.redberyl.ordermanagemnt.service.ICartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    private Cart currentCart = new Cart();

    
    @Override
    public Cart addProductsToCart(List<Long> productIds) {
        List<Product> products = productIds.stream()
                .map(productId -> productRepository.findById(productId)
                        .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + productId + " not found")))
                .collect(Collectors.toList());
        currentCart.getProducts().addAll(products);
        currentCart.calculateTotalPrice();
        return cartRepository.save(currentCart);
    }
    
    
   
    
    

    @Override
    public String generateInvoice() { 
        StringBuilder invoice = new StringBuilder("Invoice\n\n");
        double total = 0.0;

        for (Product product : currentCart.getProducts()) {
            invoice.append("Product: ").append(product.getTitle())
                    .append(" | Price: $").append(product.getPrice()).append("\n");
            total += product.getPrice();
        }

        invoice.append("\nTotal: $").append(total);
        return invoice.toString();
    }
}
