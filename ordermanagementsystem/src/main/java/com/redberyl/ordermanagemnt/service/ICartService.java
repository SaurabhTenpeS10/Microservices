package com.redberyl.ordermanagemnt.service;

import com.redberyl.ordermanagemnt.model.Cart;

import java.util.List;



public interface ICartService {
	
    Cart addProductsToCart(List<Long> productIds);
    
    String generateInvoice();
}
