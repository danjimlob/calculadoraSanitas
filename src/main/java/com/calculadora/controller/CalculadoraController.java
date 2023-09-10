package com.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.service.CalculadoraService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Calculadora API", tags = "Calculadora")
public class CalculadoraController {
	
	private final CalculadoraService calculadoraService;

	@Autowired
    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }
	
	@GetMapping("/sumar")
    @ApiOperation(value = "Realiza una suma", response = Integer.class)
    public int sumar(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
    	return calculadoraService.sumar(num1, num2);
    }

	@GetMapping("/restar")
    @ApiOperation(value = "Realiza una resta", response = Integer.class)
    public int restar(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculadoraService.restar(num1, num2);
    }
	/*Sumar: /sumar?num1=5&num2=3
Restar: /restar?num1=10&num2=4*/
}
