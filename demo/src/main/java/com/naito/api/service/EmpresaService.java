package com.naito.api.service;

import com.naito.api.entity.Empresa;
import com.naito.api.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpresaService  {
		
	@Autowired
	EmpresaRepository empresaRepository;

	public ArrayList<Empresa> obterEmpresa() {
	return   (ArrayList<Empresa>) this.empresaRepository.findAll();
	}

	public ResponseEntity.BodyBuilder atualizarEmpresa(String nome, Long id) {

		final Empresa empresa = this.empresaRepository.save(new Empresa(id, nome));

		if (empresa != null)
			return ResponseEntity.ok();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity.BodyBuilder inserirEmpresa(String nome, Long id, String cnpj, String usuarioInclusao) {

		final Empresa empresa = this.empresaRepository.save(new Empresa(id, nome, cnpj, usuarioInclusao));

		if (empresa != null)
			return ResponseEntity.ok();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
