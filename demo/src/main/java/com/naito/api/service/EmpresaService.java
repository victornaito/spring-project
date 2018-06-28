package com.naito.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naito.api.entity.Empresa;
import com.naito.api.repository.EmpresaRepository;

@Service
public class EmpresaService {
		
	@Autowired
	EmpresaRepository empresaRepository;

	public ArrayList<Empresa> obterEmpresa() {
	return   (ArrayList<Empresa>) this.empresaRepository.findAll();
	}
}
