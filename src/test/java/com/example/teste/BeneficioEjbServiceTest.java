package com.example.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.backend.model.Beneficio;
import com.example.backend.repository.BeneficioRepository;
import com.example.backend.service.BeneficioEjbService;

@ExtendWith(MockitoExtension.class)
public class BeneficioEjbServiceTest {
	 @Mock
	    private BeneficioRepository repository;

	    @InjectMocks
	    private BeneficioEjbService service;

	    @Test
	    @DisplayName("Deve transferir valores com sucesso entre dois benefícios")
	    void deveTransferirComSucesso() {
	        
	        Beneficio b1 = new Beneficio(1L, "Alimentação", new BigDecimal("500.00"));
	        Beneficio b2 = new Beneficio(2L, "Transporte", new BigDecimal("300.00"));
	        
	        when(repository.findById(1L)).thenReturn(Optional.of(b1));
	        when(repository.findById(2L)).thenReturn(Optional.of(b2));

	      
	        service.transfer(1L, 2L, new BigDecimal("100.00"));

	      
	        assertEquals(new BigDecimal("400.00"), b1.getValor());
	        assertEquals(new BigDecimal("400.00"), b2.getValor());
	        verify(repository, times(1)).save(b1);
	        verify(repository, times(1)).save(b2);
	    }

	    @Test
	    @DisplayName("Deve lançar erro quando saldo for insuficiente")
	    void deveLancarErroSaldoInsuficiente() {
	    	// Cenário: b1 tem apenas 50.00
	        Beneficio b1 = new Beneficio(1L, "Alimentação", new BigDecimal("50.00"));
	        Beneficio b2 = new Beneficio(2L, "Transporte", new BigDecimal("300.00")); 

	       
	        when(repository.findById(1L)).thenReturn(Optional.of(b1));
	        when(repository.findById(2L)).thenReturn(Optional.of(b2));

	        
	        assertThrows(RuntimeException.class, () -> {
	            // Tentar tirar 100.00 de quem só tem 50.00
	            service.transfer(1L, 2L, new BigDecimal("100.00"));
	        });
	    }

}
