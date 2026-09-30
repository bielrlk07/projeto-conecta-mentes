package com.conecta_mentes.conectamentes.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.conecta_mentes.conectamentes.model.Criança;
import com.conecta_mentes.conectamentes.model.CriançaRepository;
import com.conecta_mentes.conectamentes.model.Mentorado;
import com.conecta_mentes.conectamentes.view.*;

public class ControllerMenu {

	private ViewMenu view;
	private CriançaRepository criancaRepository;
    private Mentorado mentoradoLogado;

    public ControllerMenu(ViewMenu view,
                          CriançaRepository repository,
                          Mentorado mentoradoLogado) {

        this.view = view;
        this.criancaRepository = repository;
        this.mentoradoLogado = mentoradoLogado;
        
     // Listener do botão Cadastrar Criança
        if (view.getCadastroCria() != null) {
            view.getCadastroCria()
                .addActionListener(e -> abrirCadastro());
        }

      //listener do botão Informações Criança
        if (view.getBtnInformacoesDaCria() != null) {
            view.getBtnInformacoesDaCria()
                .addActionListener(e -> mostrarInformacoes());
        }
    }

    
	private void abrirCadastro() {

		 ViewCadastroCriança cadastro =
		            new ViewCadastroCriança(criancaRepository, mentoradoLogado);

		    cadastro.setVisible(true);
		    view.dispose();   // fecha o menu atual
    }
	
	private void mostrarInformacoes() {

	    try {

	        List<Criança> lista =
	                criancaRepository.findByMentorado(mentoradoLogado);

	        if (lista == null || lista.isEmpty()) {

	            JOptionPane.showMessageDialog(
	                    null,
	                    "Nenhuma criança cadastrada.",
	                    "Aviso",
	                    JOptionPane.WARNING_MESSAGE
	            );

	            return;
	        }

	        StringBuilder mensagem = new StringBuilder();

	        mensagem.append("Crianças cadastradas:\n\n");

	        for (Criança c : lista) {
	        	
	        	String observacoes = c.getObservacoes();

	        	if (observacoes == null || observacoes.isBlank()) {
	        	    observacoes = "Nenhuma observação.";
	        	} else {
	        	    observacoes = observacoes.replace("\\n", "\n");
	        	}

	            mensagem.append("Nome: ")
	                    .append(c.getNome())
	                    .append("\nIdade: ")
	                    .append(c.getIdade())
	                    .append("\nObservações: \n")
	                    .append(c.getObservacoes())
	                    .append("\n----------------------\n");
	        }

	        JOptionPane.showMessageDialog(
	                null,
	                mensagem.toString(),
	                "Informações das Crianças",
	                JOptionPane.INFORMATION_MESSAGE
	        );

	    } catch (Exception ex) {

	        JOptionPane.showMessageDialog(
	                null,
	                "Erro ao buscar informações: " + ex.getMessage(),
	                "Erro",
	                JOptionPane.ERROR_MESSAGE
	        );
	    }
	}
}