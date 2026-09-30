package com.conecta_mentes.conectamentes.controller;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.conecta_mentes.conectamentes.model.*;
import com.conecta_mentes.conectamentes.view.ViewCadastroCriança;
import com.conecta_mentes.conectamentes.view.ViewMenu;

public class ControllerCadastroCriança {

	 private ViewCadastroCriança view;
	 private Mentorado mentoradoLogado;
	    private CriançaRepository criancaRepository;

	    public ControllerCadastroCriança(ViewCadastroCriança view,
                CriançaRepository repository,
                Mentorado mentoradoLogado) {

			this.view = view;
			this.criancaRepository = repository;
			this.mentoradoLogado = mentoradoLogado;
			
			System.out.println(criancaRepository);
	        
	        this.view.getBtnCadastrarCria()
            .addActionListener(e -> cadastrarCriança());
	        
	        // Adiciona o evento ao botão Voltar
	        this.view.getBtnVoltaMenu().addActionListener(e -> voltarParaMenu());
	    }
	    
	    private void cadastrarCriança() {

	        try {

	            String nome = view.getTextFieldNomeCria().getText();
	            String idadeTexto = view.getTextFieldIdadeCria().getText();
	            String observacoes = view.getTextAreaObsCria().getText();

	            if (nome.isEmpty() || idadeTexto.isEmpty()) {
	                JOptionPane.showMessageDialog(null,
	                        "Nome e idade são obrigatórios.",
	                        "Erro",
	                        JOptionPane.WARNING_MESSAGE);
	                return;
	            }

	            Integer idade = Integer.parseInt(idadeTexto);

	            Criança crianca = new Criança();
	            crianca.setNome(nome);
	            crianca.setIdade(idade);
	            crianca.setObservacoes(observacoes);
	            crianca.setMentorado(mentoradoLogado);

	            criancaRepository.save(crianca);

	            JOptionPane.showMessageDialog(null,
	                    "Criança cadastrada com sucesso!",
	                    "Sucesso",
	                    JOptionPane.INFORMATION_MESSAGE);

	            voltarParaMenu();

	        } catch (NumberFormatException ex) {

	            JOptionPane.showMessageDialog(null,
	                    "Idade deve ser numérica.",
	                    "Erro",
	                    JOptionPane.WARNING_MESSAGE);

	        } catch (Exception ex) {

	            JOptionPane.showMessageDialog(null,
	                    "Erro ao salvar: " + ex.getMessage(),
	                    "Erro",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    // Método responsável por voltar ao menu
	    private void voltarParaMenu() {

	        view.dispose(); // fecha cadastro

	        ViewMenu menu = new ViewMenu(mentoradoLogado, criancaRepository);
	        new ControllerMenu(menu, criancaRepository, mentoradoLogado);

	        menu.setVisible(true);
	    }
	}