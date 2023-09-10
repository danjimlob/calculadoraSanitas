package com.calculadora.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.calculadora.service.CalculadoraService;
import com.calculadora.service.TracerAPI;

public class CalculadoraControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CalculadoraService calculadoraService;
    
    @Mock
    private TracerAPI tracer;

    @InjectMocks
    private CalculadoraController calculadoraController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(calculadoraController).build();
    }

    @Test
    public void testSumar() throws Exception {
        int num1 = 5;
        int num2 = 3;
        int resultadoEsperado = num1 + num2;

        when(calculadoraService.sumar(num1, num2)).thenReturn(resultadoEsperado);

        mockMvc.perform(get("/sumar")
                .param("num1", String.valueOf(num1))
                .param("num2", String.valueOf(num2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(resultadoEsperado)));
    }

    @Test
    public void testRestar() throws Exception {
        int num1 = 10;
        int num2 = 4;
        int resultadoEsperado = num1 - num2;

        when(calculadoraService.restar(num1, num2)).thenReturn(resultadoEsperado);

        mockMvc.perform(get("/restar")
                .param("num1", String.valueOf(num1))
                .param("num2", String.valueOf(num2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(resultadoEsperado)));
    }
}
