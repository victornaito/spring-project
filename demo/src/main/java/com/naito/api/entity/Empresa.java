package com.naito.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "empresa")
public class Empresa {
	
	public Empresa() {
		super();
	}

	public Empresa(Long id, String nome, String cnpj, String usuarioInclusao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.usuarioInclusao = usuarioInclusao;
	}

	public Empresa(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

    @Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", timestamp=" + timestamp
				+ ", usuarioInclusao=" + usuarioInclusao + "]";
	}

	@Id
	private Long id;
	
	private String nome;
	
	private String cnpj;
	
	@Temporal(TemporalType.DATE)
	private Date timestamp;
	
	private String usuarioInclusao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date date) {
		this.timestamp = date;
	}

	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	@PrePersist
	public void onPrePersist(){
		this.setUsuarioInclusao(usuarioInclusao);
		this.setTimestamp(new Date());
	}
	
	@PreUpdate
	public void onPreUpdate() {
		this.setUsuarioInclusao(usuarioInclusao);
		this.setTimestamp(new Date());
	}
}
