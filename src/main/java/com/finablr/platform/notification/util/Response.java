package com.finablr.platform.notification.util;

public class Response<T> {

	private Integer status;
	private T data;
	private String message;
	private Object error;

	public Response() {
	}

	public Response(Integer status, T data, String message, Object error) {
		this.status = status;
		this.data = data;
		this.message = message;
		this.error = error;
	}

}
