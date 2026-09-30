package com.conecta_mentes.conectamentes.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.conecta_mentes.conectamentes.controller.ControllerAgendamento;
import com.conecta_mentes.conectamentes.model.CriançaRepository;
import com.conecta_mentes.conectamentes.model.Mentorado;
import com.conecta_mentes.conectamentes.model.TipoMentor;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ViewMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCadastroCria;
	private JButton btnInformaesDaCria;
	private JButton btnAgendamento;
	private Mentorado mentoradoLogado;
	private ApplicationContext context;
	private ControllerAgendamento controller;
	private CriançaRepository criancaRepository;

	 public ViewMenu(Mentorado mentoradoLogado, CriançaRepository criancaRepository) {
	        this.mentoradoLogado = mentoradoLogado;
	        this.criancaRepository = criancaRepository;
	        inicializarComponentes();
	    }

	    private void inicializarComponentes() {
		
		System.out.println("Tipo mentor logado: " 
		        + mentoradoLogado.getTipoMentor());

	    this.mentoradoLogado = mentoradoLogado;
		setTitle("Menu Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 507);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAgendamento = new JButton("Opções de Agendamento");
		btnAgendamento.setBackground(new Color(255, 255, 255));
		btnAgendamento.setForeground(Color.BLACK);
		btnAgendamento.setBounds(52, 380, 326, 20);
		contentPane.add(btnAgendamento);
		
		//só cria os botoes se não for INSTITUIÇÃO
		if (mentoradoLogado.getTipoMentor() != TipoMentor.INSTITUICAO) {

			 	btnInformaesDaCria = new JButton("Informações da Criança");
				btnInformaesDaCria.setBounds(52, 289, 326, 20);
				btnInformaesDaCria.setBackground(new Color(255, 255, 255));
				btnInformaesDaCria.setForeground(Color.BLACK);
				contentPane.add(btnInformaesDaCria);
				
		        btnCadastroCria = new JButton("Cadastrar criança");
				btnCadastroCria.setBounds(52, 203, 326, 20);
				btnCadastroCria.setBackground(new Color(255, 255, 255));
				btnCadastroCria.setForeground(Color.BLACK);
				contentPane.add(btnCadastroCria);
		   }
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		lblNewLabel.setBounds(178, 10, 108, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblConectaMentes = new JLabel("CONECTA MENTES");
		lblConectaMentes.setForeground(Color.WHITE);
		lblConectaMentes.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblConectaMentes.setBounds(63, 52, 344, 43);
		contentPane.add(lblConectaMentes);
		
		 btnAgendamento.addActionListener(e -> {

		        ViewAgendamento tela =
		                new ViewAgendamento(mentoradoLogado);

		        tela.setVisible(true);
		        dispose();
		    });
		
	}
	
	public JButton getCadastroCria() {
	    return btnCadastroCria;
	}
	
	public JButton getBtnInformacoesDaCria() {
	    return btnInformaesDaCria;
	}
}
