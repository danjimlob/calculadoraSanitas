package com.calculadoras.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // Define el código de estado HTTP 400
public class CalculadoraException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2486086756925279187L;

	public CalculadoraException(String mensaje) {
        super(mensaje);
    }
}
