package com.conecta_mentes.conectamentes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.conecta_mentes.conectamentes.model.*;
import com.conecta_mentes.conectamentes.controller.*;
import com.conecta_mentes.conectamentes.view.*;

import com.conecta_mentes.conectamentes.view.ViewCadastro;

@SpringBootApplication
@EnableScheduling  // ← ativa agendamento
public class ConectaMentesApplication {

    public static void main(String[] args) {

    	// Inicia o Spring Boot com suporte a interface gráfica
    	context = new SpringApplicationBuilder(ConectaMentesApplication.class)
    	        .headless(false)
    	        .run(args);

        // Obtém a ViewLogin gerenciada pelo Spring
        ViewLogin view = context.getBean(ViewLogin.class);
        view.setVisible(true);
    }
    
    private static ConfigurableApplicationContext context;

    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}