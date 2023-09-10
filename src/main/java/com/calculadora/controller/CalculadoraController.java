package com.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.service.CalculadoraService;
import com.calculadora.service.TracerAPI;
import com.calculadoras.exceptions.CalculadoraException;

import io.swagger.annotations.ApiOperation;

@RestController
//@Api(value = "Calculadora API", tags = "Calculadora")
public class CalculadoraController {
	
	private final CalculadoraService calculadoraService;
	private final TracerAPI tracer;

	@Autowired
    public CalculadoraController(CalculadoraService calculadoraService, TracerAPI tracer) {
        this.calculadoraService = calculadoraService;
        this.tracer = tracer;
    }
	
	@GetMapping("/sumar")
    @ApiOperation(value = "Realiza una suma", response = Integer.class)
    public int sumar(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		if(calculadoraService.comprobarParametros(num1, num2)) {
			int resultado = calculadoraService.sumar(num1, num2);
			tracer.trace(resultado);
	    	return resultado;
		}else {
            throw new CalculadoraException("Los valores no pueden ser negativos.");

		}
    }



	@GetMapping("/restar")
	@ApiOperation(value = "Realiza una resta", response = Integer.class)
	public int restar(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		if (calculadoraService.comprobarParametros(num1, num2)) {
			int resultado = calculadoraService.restar(num1, num2);
			tracer.trace(resultado);
			return resultado;
		} else {
            throw new CalculadoraException("Los valores no pueden ser negativos.");

		}
    }
}
