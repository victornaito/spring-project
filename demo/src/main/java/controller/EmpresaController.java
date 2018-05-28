package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naito.api.repository.EmpresaRepository;

import antlr.collections.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController<Empresa> {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@GetMapping(value = "/listar")
    public List obterEmpresa() {
		return (List) this.empresaRepository.findAll();
	}

}
