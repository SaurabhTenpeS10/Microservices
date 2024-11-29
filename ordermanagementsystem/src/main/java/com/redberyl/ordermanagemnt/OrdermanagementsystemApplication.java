package com.redberyl.ordermanagemnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableAspectJAutoProxy
@OpenAPIDefinition(
	    info = @Info(
	            title = "Order Management System REST API Documentation",
	            description = "The Order Management System (OMS) REST API allows users to manage  product orders, products, and users. " +
	                          "It provides endpoints for managing user accounts, adding and updating products, " +
	                          "placing orders, generating invoices, and managing shopping carts.",
	            version = "v1"
	    )
	)

public class OrdermanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdermanagementsystemApplication.class, args);
	}

}
