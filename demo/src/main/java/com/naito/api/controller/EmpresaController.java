package com.naito.api.controller;

import com.naito.api.service.EmpresaService;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.apache.commons.codec.Charsets;
import org.apache.http.util.CharsetUtils;
import org.jboss.resteasy.core.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/")
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaService;
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "empresa", produces = {MediaType.APPLICATION_JSON})
	@PostMapping("empresa")
    public ArrayList<com.naito.api.entity.Empresa> obterEmpresa() {return this.empresaService.obterEmpresa();}

	@PatchMapping("empresa")
	public void atualizarEmpresa(String nome, Long id) {
		this.empresaService.atualizarEmpresa(nome, id);
	}

	@PutMapping("empresa")
	public void inserirEmpresa(String nome, Long id, String cnpj, String usuarioInclusao) {
		this.empresaService.inserirEmpresa(nome, id, cnpj, usuarioInclusao);
	}

}
