package com.example.backend.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Beneficio;

@Repository
@EnableJpaRepositories
public interface BeneficioRepository extends JpaRepository<Beneficio, Long> {
	
	List<Beneficio> findAll();
	
	
}
