package com.naito.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naito.api.entity.Empresa;

public interface EmpresaRepository  extends JpaRepository<Empresa, Long>{
	
}
