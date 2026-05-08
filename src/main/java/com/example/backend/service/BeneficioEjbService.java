package com.example.backend.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Beneficio;
import com.example.backend.repository.BeneficioRepository;

import jakarta.transaction.Transactional;


//@Stateless
@Service
public class BeneficioEjbService {
	
	@Autowired
    private BeneficioRepository repository;

	@Transactional
	public void transfer(Long fromId, Long toId, BigDecimal amount) {
        
        Beneficio from = repository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("Origem não encontrada!"));
        Beneficio to = repository.findById(toId)
                .orElseThrow(() -> new RuntimeException("Destino não encontrado!"));

        if (from.getValor().compareTo(amount) < 0) {
            throw new RuntimeException("Saldo insuficiente!");
        }

        from.setValor(from.getValor().subtract(amount));
        to.setValor(to.getValor().add(amount));

       
        repository.save(from);
        repository.save(to);
    }
	
	public java.util.List<Beneficio> listarTodos() {
        return repository.findAll();
    }
}
