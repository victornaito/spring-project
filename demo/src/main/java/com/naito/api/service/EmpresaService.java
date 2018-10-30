package com.naito.api.service;

import com.naito.api.entity.Empresa;
import com.naito.api.fila.FilaProducer;
import com.naito.api.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@EnableAsync
public class EmpresaService  {

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	FilaProducer filaProducer;

//	@Autowired
//	ElasticTestRepository elasticTestRepository;

//	@Autowired
//	private ElasticsearchOperations es;

	public ArrayList<Empresa> obterEmpresa() {
		return (ArrayList<Empresa>) this.empresaRepository.findAll();
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

	@Async
	public ResponseEntity.BodyBuilder inserirEmpresaNoRabbit(String nome, Long id, String cnpj, String usuarioInclusao) {

		final Empresa empresa = new Empresa(id, nome, cnpj, usuarioInclusao);
		try {
			filaProducer.run(String.valueOf(Arrays.asList(empresa)));
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (empresa != null)
			return ResponseEntity.ok();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
	}
//	private List<ElasticTest> buscaClientesEnviadosPeloSigVivo() {
//
////		return elasticTestRepository.buscaClientesEnviadosPeloSigVivo();
//		return (List<ElasticTest>) elasticTestRepository.findAll();
//	}
//
//	public void efetuaEnvioDeregistrosParaOElasticSearch() {
//		buscaClientesEnviadosPeloSigVivo();
//
//		final Map<String, String> asMap = es.getClient().settings().getAsMap();
//
//		asMap.forEach((k, v) -> {
//			System.out.println(k + " = " + v);
//		});
//		System.out.println("--ElasticSearch--");
//	}


}
