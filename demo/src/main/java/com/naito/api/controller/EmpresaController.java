package com.naito.api.controller;

import com.naito.api.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaService;
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/empresa", produces = {MediaType.APPLICATION_JSON})
	@PostMapping("/empresa")
    public ArrayList<com.naito.api.entity.Empresa> obterEmpresa() {return this.empresaService.obterEmpresa();}

	@PatchMapping("/empresa")
	public void atualizarEmpresa(String nome, Long id) {
		this.empresaService.atualizarEmpresa(nome, id);
	}

	@PutMapping("/empresa")
	public void inserirEmpresa(String nome, Long id, String cnpj, String usuarioInclusao) {
		this.empresaService.inserirEmpresa(nome, id, cnpj, usuarioInclusao);
	}

	@PostMapping(value = "/painel")
	public void inserirEmpresaNoRabbit(@RequestBody @Valid String nome, Long id, String cnpj, String usuarioInclusao) {
		this.empresaService.inserirEmpresaNoRabbit(nome, id, cnpj, usuarioInclusao);
	}
}
