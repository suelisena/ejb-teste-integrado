package com.example.backend.controller;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Beneficio;
import com.example.backend.repository.BeneficioRepository;
import com.example.backend.service.BeneficioEjbService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/beneficios")
public class BeneficioController {

	@Autowired
	private BeneficioRepository beneficioRepository;
	
	@Autowired
	private BeneficioEjbService beneficioService;
	
	@GetMapping
    public List<Beneficio> list() {
        return beneficioRepository.findAll();
    }
	
	@GetMapping("/transferir")
	public String testarTransferencia(
		@RequestParam Long de, 
		@RequestParam Long para, 
		@RequestParam BigDecimal valor) {
		    
		try {
		     beneficioService.transfer(de, para, valor);
		     return "Sucesso! Transferência de R$ " + valor + " realizada.";
		    } catch (Exception e) {
		     return "Erro na transferência: " + e.getMessage();
		    }

	}
}