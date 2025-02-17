package com.jspiders.contactmanagement.entity;

import lombok.Data;

@Data
public class Response<T> {
	private String message;
	private T data;
	private int httpStatusCode;
}
