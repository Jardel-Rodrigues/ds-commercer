package com.softstrem.dscommerce.dtos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO extends CustomErrorDTO {

	private List<FieldMessegeDTO> errors = new ArrayList<>();

	public ValidationErrorDTO(Instant timestamp, Integer status, String message, String path) {
		super(timestamp, status, message, path);

	}

	public List<FieldMessegeDTO> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messege) {
		errors.add(new FieldMessegeDTO(fieldName, messege));
	}

}
