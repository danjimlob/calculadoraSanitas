package com.calculadora.service.impl;

import org.springframework.stereotype.Service;

import com.calculadora.service.CalculadoraService;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

    @Override
    public int sumar(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int restar(int num1, int num2) {
        return num1 - num2;
    }
    @Override
	public boolean comprobarParametros(int num1, int num2) {
		if(num1<0 && num2<0) {
			return false;
		}
		else {
			return true;
		}		
	}
}
