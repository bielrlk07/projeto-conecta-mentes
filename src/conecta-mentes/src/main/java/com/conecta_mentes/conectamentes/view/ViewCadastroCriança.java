package com.conecta_mentes.conectamentes.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import com.conecta_mentes.conectamentes.controller.*;
import com.conecta_mentes.conectamentes.model.CriançaRepository;
import com.conecta_mentes.conectamentes.model.Mentorado;

import java.awt.Color;
import java.awt.Font;

public class ViewCadastroCriança extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeCria;
	private JTextField textFieldIdadeCria;
	private JTextArea textAreaObsCria;
	private JButton btnCadastrarCria;
	private JButton btnVoltaMenu;
	
	private Mentorado mentoradoLogado;

	private CriançaRepository criancaRepository;

	public ViewCadastroCriança(CriançaRepository repository,
	                           Mentorado mentoradoLogado) {

	    this.criancaRepository = repository;
	    this.mentoradoLogado = mentoradoLogado;
	    
	    System.out.println("Tela Cadastro criada");

		setTitle("Cadastro da Criança");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome da Criança");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 15, 131, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdadeCria = new JLabel("Idade da Criança");
		lblIdadeCria.setForeground(Color.WHITE);
		lblIdadeCria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdadeCria.setBounds(10, 85, 108, 22);
		contentPane.add(lblIdadeCria);
		
		JLabel lblNewLabel_1 = new JLabel("Observações da criança:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(231, 27, 165, 32);
		contentPane.add(lblNewLabel_1);
		
		textFieldIdadeCria = new JTextField();
		textFieldIdadeCria.setColumns(10);
		textFieldIdadeCria.setBounds(10, 118, 56, 32);
		contentPane.add(textFieldIdadeCria);
		
		textFieldNomeCria = new JTextField();
		textFieldNomeCria.setBounds(10, 48, 158, 26);
		contentPane.add(textFieldNomeCria);
		textFieldNomeCria.setColumns(10);	
		
		btnCadastrarCria = new JButton("Cadastrar");
		btnCadastrarCria.setBackground(new Color(255, 255, 255));
		btnCadastrarCria.setForeground(Color.BLACK);
		btnCadastrarCria.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCadastrarCria.setBounds(35, 171, 143, 48);
		contentPane.add(btnCadastrarCria);
		
		btnVoltaMenu = new JButton("Voltar");
		btnVoltaMenu.setBackground(new Color(255, 255, 255));
		btnVoltaMenu.setBounds(66, 230, 84, 20);
		contentPane.add(btnVoltaMenu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(231, 64, 153, 167);
		contentPane.add(scrollPane);
		
		textAreaObsCria = new JTextArea();
		textAreaObsCria.setForeground(Color.BLACK);
		scrollPane.setViewportView(textAreaObsCria);
		textAreaObsCria.setLineWrap(true);          // quebra linha automática
		textAreaObsCria.setWrapStyleWord(true);
		
		new ControllerCadastroCriança(this, repository, mentoradoLogado);

	}
	
	public Mentorado getMentoradoLogado() {
	    return mentoradoLogado;
	}
	
	public JButton getBtnVoltaMenu() {
	    return btnVoltaMenu;
	}

	public JButton getBtnCadastrarCria() {
	    return btnCadastrarCria;
	}

	public JTextField getTextFieldNomeCria() {
	    return textFieldNomeCria;
	}

	public JTextField getTextFieldIdadeCria() {
	    return textFieldIdadeCria;
	}

	public JTextArea getTextAreaObsCria() {
	    return textAreaObsCria;
	}
}
