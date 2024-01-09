package com.softstrem.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

	private List<FieldMessege> errors = new ArrayList<>();

	public ValidationError(Instant timestamp, Integer status, String message, String path) {
		super(timestamp, status, message, path);

	}

	public List<FieldMessege> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messege) {
		errors.add(new FieldMessege(fieldName, messege));
	}

}
