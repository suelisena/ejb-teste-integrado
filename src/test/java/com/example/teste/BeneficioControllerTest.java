package com.example.teste;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.backend.controller.BeneficioController;
import com.example.backend.service.BeneficioEjbService;

@WebMvcTest(BeneficioController.class)
public class BeneficioControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private BeneficioEjbService service;

    @Test
    void deveRetornarStatusOkAoTransferir() throws Exception {
        mockMvc.perform(get("/api/v1/beneficios/transferir")
                .param("de", "1")
                .param("para", "2")
                .param("valor", "100.00"))
                .andExpect(status().isOk());
    }
}
