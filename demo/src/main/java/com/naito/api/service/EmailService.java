package com.naito.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviar() {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("vinicius.sturaro@redetendencia.com.br");
        email.setSubject("pao");
        email.setText("Enviei este e-mail usando Spring Boot.");
        mailSender.send(email);
    }
}
