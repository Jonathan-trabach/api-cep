package br.com.cep.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FieldMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String message;

	
}
