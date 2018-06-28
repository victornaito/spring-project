package com.naito.api.controller;

import com.naito.api.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/")
public class EmpresaController<Empresa> {
	
	@Autowired
	EmpresaService empresaService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("empresa")
    public ArrayList<com.naito.api.entity.Empresa> obterEmpresa() {
		return  this.empresaService.obterEmpresa();
	}

	@PatchMapping("empresa")
	public void atualizarEmpresa(String nome, Long id) {
		this.empresaService.atualizarEmpresa(nome, id);
	}

	@PutMapping("empresa")
	public void inserirEmpresainserirEmpresa(String nome, Long id, String cnpj, String usuarioInclusao) {
		this.empresaService.inserirEmpresa(nome, id, cnpj, usuarioInclusao);
	}

}
