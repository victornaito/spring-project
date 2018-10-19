package com.naito.api;

import com.naito.api.repository.EmpresaRepository;
import com.naito.api.service.ClientApiService;
import com.naito.api.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	ClientApiService clientApiService;

	@Autowired
	EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner commandLineRunner() {
		return args -> {
//			this.empresaRepository.save(new Empresa(3L,"pao", "cnpj", "Victor"));
//			this.empresaRepository.save(new Empresa(4L,"pao", "cnpj", "aa"));
//			emailService.enviar();
//			System.out.println("email enviado");
			clientApiService.consumirApi();
		};
	}
}
