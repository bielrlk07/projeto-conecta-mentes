package com.conecta_mentes.conectamentes.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.conecta_mentes.conectamentes.controller.ControllerCadastro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.conecta_mentes.conectamentes.model.ExceptionAcesso;
import com.conecta_mentes.conectamentes.model.SegmentoEnsino;
import com.conecta_mentes.conectamentes.model.TipoMentor;
import java.awt.Color;

@Component
public class ViewCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel viewCadastro;
	private JTextField campoNome;
	private JTextField campoSenha;
	private JTextField campoTelefone;
	private JTextField campoEmail;
	private JTextField campoGraduaçao;
	private JTextField campoEndereço;
	private JLabel lblEmail;
	private JTextField campoFormaçao;
	private JCheckBox chckbxTerapeuta;
	private JCheckBox chckboxPais;
	private JCheckBox chckbxProfessor;
	private JCheckBox chckbxInstituio;
	private JButton botaoCadastro;
	private JSpinner spinnerNumPessoas;
	private final ControllerCadastro controller;
	private JComboBox comboBoxSegEnsino;
	
	private void limparCampos() {

	    // Limpa textos
	    campoNome.setText("");
	    campoSenha.setText("");
	    campoEmail.setText("");
	    campoTelefone.setText("");
	    campoEndereço.setText("");
	    campoGraduaçao.setText("");
	    campoFormaçao.setText("");

	    // Reseta spinner
	    spinnerNumPessoas.setValue(0);

	    // Desmarca checkboxes
	    chckboxPais.setSelected(false);
	    chckbxTerapeuta.setSelected(false);
	    chckbxProfessor.setSelected(false);
	    chckbxInstituio.setSelected(false);

	    // Reseta comboBox para primeiro item
	    comboBoxSegEnsino.setSelectedIndex(0);
	}
	public ViewCadastro(ControllerCadastro controller) {
	    this.controller = controller;
		
		setTitle("Tela de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 300);
		viewCadastro = new JPanel();
		viewCadastro.setBackground(Color.DARK_GRAY);
		viewCadastro.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(viewCadastro);
		viewCadastro.setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setForeground(Color.WHITE);
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCadastro.setBounds(251, 0, 133, 37);
		viewCadastro.add(lblCadastro);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(10, 45, 70, 24);
		viewCadastro.add(lblNome);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(10, 80, 70, 24);
		viewCadastro.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(210, 45, 70, 24);
		viewCadastro.add(lblSenha);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setBounds(210, 80, 70, 24);
		viewCadastro.add(lblTelefone);
		
		campoNome = new JTextField();
		campoNome.setBounds(54, 47, 107, 20);
		viewCadastro.add(campoNome);
		campoNome.setColumns(10);
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		campoEmail.setBounds(54, 82, 143, 20);
		viewCadastro.add(campoEmail);
		
		campoSenha = new JTextField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(258, 47, 107, 20);
		viewCadastro.add(campoSenha);
		
		campoTelefone = new JTextField();
		campoTelefone.setColumns(10);
		campoTelefone.setBounds(258, 82, 107, 20);
		viewCadastro.add(campoTelefone);
		
		chckbxTerapeuta = new JCheckBox("Terapeuta");
		chckbxTerapeuta.setBackground(Color.DARK_GRAY);
		chckbxTerapeuta.setForeground(Color.WHITE);
		chckbxTerapeuta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxTerapeuta.setBounds(128, 127, 97, 23);
		viewCadastro.add(chckbxTerapeuta);
		
	    chckboxPais = new JCheckBox("Pais/Cuidadores");
	    chckboxPais.setBackground(Color.DARK_GRAY);
	    chckboxPais.setForeground(Color.WHITE);
	    chckboxPais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckboxPais.setBounds(6, 127, 122, 23);
		viewCadastro.add(chckboxPais);
		
		botaoCadastro = new JButton("Cadastrar");
		botaoCadastro.setForeground(Color.BLACK);
		botaoCadastro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoCadastro.setBounds(452, 205, 133, 37);
		viewCadastro.add(botaoCadastro);
		
		chckbxProfessor = new JCheckBox("Professor");
		chckbxProfessor.setBackground(Color.DARK_GRAY);
		chckbxProfessor.setForeground(Color.WHITE);
		chckbxProfessor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxProfessor.setBounds(227, 127, 97, 23);
		viewCadastro.add(chckbxProfessor);
		
		chckbxInstituio = new JCheckBox("Instituição");
		chckbxInstituio.setBackground(Color.DARK_GRAY);
		chckbxInstituio.setForeground(Color.WHITE);
		chckbxInstituio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxInstituio.setBounds(326, 127, 97, 23);
		viewCadastro.add(chckbxInstituio);
		
		//garante que só uma checkbox é marcada:
		ButtonGroup grupoTipo = new ButtonGroup();
		grupoTipo.add(chckboxPais);
		grupoTipo.add(chckbxTerapeuta);
		grupoTipo.add(chckbxProfessor);
		grupoTipo.add(chckbxInstituio);
		
		spinnerNumPessoas = new JSpinner();
		spinnerNumPessoas.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerNumPessoas.setBounds(10, 203, 30, 20);
		viewCadastro.add(spinnerNumPessoas);
		
		JLabel lblNewLabel_2 = new JLabel("Número de Pessoas");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(10, 165, 103, 14);
		viewCadastro.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("em Casa:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(10, 178, 70, 14);
		viewCadastro.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Formação:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(227, 205, 70, 14);
		viewCadastro.add(lblNewLabel_4);
		
		campoGraduaçao = new JTextField();
		campoGraduaçao.setColumns(10);
		campoGraduaçao.setBounds(227, 173, 97, 24);
		viewCadastro.add(campoGraduaçao);
		
		JLabel lblNewLabel_4_1 = new JLabel("Graduação:");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setBounds(227, 157, 70, 14);
		viewCadastro.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Segmento De Ensino");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setBounds(90, 189, 107, 14);
		viewCadastro.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Endereço");
		lblNewLabel_4_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_2.setBounds(390, 50, 70, 14);
		viewCadastro.add(lblNewLabel_4_1_2);
		
		campoEndereço = new JTextField();
		campoEndereço.setColumns(10);
		campoEndereço.setBounds(452, 45, 133, 84);
		viewCadastro.add(campoEndereço);
		
		campoFormaçao = new JTextField();
		campoFormaçao.setColumns(10);
		campoFormaçao.setBounds(227, 229, 97, 24);
		viewCadastro.add(campoFormaçao);
		
		comboBoxSegEnsino = new JComboBox();
		comboBoxSegEnsino.setForeground(Color.WHITE);
		comboBoxSegEnsino.setModel(new DefaultComboBoxModel(SegmentoEnsino.values()));
		comboBoxSegEnsino.setBounds(90, 217, 97, 20);
		viewCadastro.add(comboBoxSegEnsino);
		
		botaoCadastro.addActionListener(e -> {

		    try {

		        String nome = campoNome.getText();
		        String senha = campoSenha.getText();
		        String email = campoEmail.getText();
		        String telefone = campoTelefone.getText();
		        String endereco = campoEndereço.getText();
		        String graduacao = campoGraduaçao.getText();
		        String formacao = campoFormaçao.getText();
		        int nPessoas = (int) spinnerNumPessoas.getValue();

		        SegmentoEnsino segmentoEnsino =
		                (SegmentoEnsino) comboBoxSegEnsino.getSelectedItem();

		        TipoMentor tipoMentor = null;

		        if (chckboxPais.isSelected()) {
		            tipoMentor = TipoMentor.PAIS;
		        } else if (chckbxTerapeuta.isSelected()) {
		            tipoMentor = TipoMentor.TERAPEUTA;
		        } else if (chckbxProfessor.isSelected()) {
		            tipoMentor = TipoMentor.PROFESSOR;
		        } else if (chckbxInstituio.isSelected()) {
		            tipoMentor = TipoMentor.INSTITUICAO;
		        }

		        controller.cadastrarMentorado(
		                nome,
		                senha,
		                email,
		                telefone,
		                endereco,
		                nPessoas,
		                graduacao,
		                formacao,
		                segmentoEnsino,
		                tipoMentor
		        );

		        JOptionPane.showMessageDialog(
		                null,
		                "Cadastro realizado com sucesso!",
		                "Sucesso",
		                JOptionPane.INFORMATION_MESSAGE
		        );

		        limparCampos();
		        
		     // Fecha tela de cadastro
		        this.dispose();

		    } catch (ExceptionAcesso ex) {

		        // EXCEÇÕES PERSONALIZADAS
		        JOptionPane.showMessageDialog(
		                null,
		                ex.getMessage(),
		                "Erro de validação",
		                JOptionPane.WARNING_MESSAGE
		        );

		    } catch (Exception ex) {

		        JOptionPane.showMessageDialog(
		                null,
		                "Erro inesperado: " + ex.getMessage(),
		                "Erro",
		                JOptionPane.ERROR_MESSAGE
		        );
		    }

		});

	}

}
