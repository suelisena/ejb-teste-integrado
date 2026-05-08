
package com.example.backend.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "beneficio")
public class Beneficio {

	
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private boolean ativo;
	
	@jakarta.persistence.Version
	private long version;
	
	
	public Beneficio(long id, String nome, BigDecimal valor) {
	    this.id = id;
	    this.nome = nome;
	    this.valor = valor;
	}
	
	public Beneficio() {
		
	}
	
	public Beneficio(Long id, String nome, String descricao, BigDecimal valor, boolean ativo, int version) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.ativo = ativo;
		this.version = version;
	}

	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public long getVersion() {
		return version;
	}


	public void setVersion(long l) {
		this.version = l;
	}
	
	
}

