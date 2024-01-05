package com.softstrem.dscommerce.dto;

import java.time.Instant;

public class CustomError {

	private Instant timestamp;
	private Integer status;
	private String message;
	private String path;

	public CustomError(Instant timestamp, Integer status, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

}
