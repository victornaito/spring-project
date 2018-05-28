package com.naito.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.naito.api.entity.Empresa;
import com.naito.api.repository.EmpresaRepository;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	EmpresaRepository empresaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		
		System.out.println("passou");
	}
	
//	@Bean
//    public CommandLineRunner commandLineRunner() {
//		return args -> {
//			this.empresaRepository.save(new Empresa(3L,"pao", "cnpj", "Victor"));
//			this.empresaRepository.save(new Empresa(4L,"pao", "cnpj", "Emanuel"));
//		};
//	}
}
