package com.naito.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naito.api.service.EmpresaService;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController<Empresa> {
	
	@Autowired
	EmpresaService empresaService;
	
	@GetMapping("listar")
    public  ArrayList<Empresa> obterEmpresa() {
		return (ArrayList<Empresa>) this.empresaService.obterEmpresa();
	}

}
