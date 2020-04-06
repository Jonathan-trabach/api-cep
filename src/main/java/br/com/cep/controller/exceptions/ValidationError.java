package br.com.cep.controller.exceptions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError{
	private static final long serialVersionUID = 1L;

	@Getter
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public void addError(String fieldName, String messagem) {
		this.errors.add(FieldMessage.builder()
						.fieldName(fieldName)
						.message(messagem)
						.build());
	}
}
