package com.example.backend;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.backend.model.Beneficio;
import com.example.backend.repository.BeneficioRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		System.setProperty("server.port", "9090");
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Autowired
	private BeneficioRepository beneficioRepository;

	@Override
	public void run(String... args) throws Exception {
		this.beneficioRepository.findAll();
		
	    Beneficio b1 = new Beneficio(0, null, null);
	    b1.setNome("Auxílio Alimentação");
	    b1.setDescricao("Crédito mensal para supermercado");
	    b1.setValor(new BigDecimal("600.00"));
	    b1.setAtivo(true);
	    b1.setVersion(0L);
	    beneficioRepository.save(b1);
	    
	    Beneficio b2 = new Beneficio(0, null, null);
	    b2.setNome("Auxílio Transporte");
	    b2.setDescricao("Ônibus/Metrô");
	    b2.setValor(new BigDecimal("200.00"));
	    b2.setAtivo(true);
	    b2.setVersion(0L);
	    
	    beneficioRepository.save(b2);
	    
	    System.out.println(">>> DADOS INSERIDOS COM SUCESSO VIA REPOSITORY! <<<");
	}

}
