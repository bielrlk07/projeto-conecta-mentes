package com.conecta_mentes.conectamentes.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import com.conecta_mentes.conectamentes.ConectaMentesApplication;
import com.conecta_mentes.conectamentes.controller.ControllerAgendamento;
import com.conecta_mentes.conectamentes.controller.ControllerMenu;
import com.conecta_mentes.conectamentes.model.Criança;
import com.conecta_mentes.conectamentes.model.ExceptionAcesso;
import com.conecta_mentes.conectamentes.model.Mentorado;

import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.awt.Font;

public class ViewAgendamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	  private JComboBox<Criança> comboNomeCria;
	    private JSpinner spinnerDia;
	    private JSpinner spinnerMes;
	    private JSpinner spinnerHora;
	    private JSpinner spinnerMinuto;
	    private JTextArea textAreaDetalhes;
	    private JButton btnVoltarAoMenu;
	    private JButton btnAgendar;

	    private Mentorado mentoradoLogado;
	    private ControllerAgendamento controller;
	    

	    public ViewAgendamento(Mentorado mentoradoLogado) {

	        this.mentoradoLogado = mentoradoLogado;

	        // Aqui pegamos o controller do Spring manualmente
	        this.controller = ConectaMentesApplication
	                .getContext()
	                .getBean(ControllerAgendamento.class);

	        inicializarComponentes();
	        carregarCriancas();
	    }
	         
	    private void inicializarComponentes() {       
		setTitle("Agendamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 482);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecionar a Criança");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(31, 23, 139, 12);
		contentPane.add(lblNewLabel);
		
		comboNomeCria = new JComboBox();
		comboNomeCria.setBounds(31, 46, 108, 22);
		contentPane.add(comboNomeCria);
		
		spinnerDia = new JSpinner();
		spinnerDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDia.setBounds(31, 138, 54, 30);
		contentPane.add(spinnerDia);
		
		JLabel lblNewLabel_1 = new JLabel("DIA");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(31, 97, 54, 30);
		contentPane.add(lblNewLabel_1);
		
		spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMes.setBounds(115, 138, 55, 30);
		contentPane.add(spinnerMes);
		
		JLabel lblNewLabel_2 = new JLabel("MÊS");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(115, 98, 44, 28);
		contentPane.add(lblNewLabel_2);
		
		spinnerHora = new JSpinner();
		spinnerHora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerHora.setBounds(31, 231, 54, 30);
		contentPane.add(spinnerHora);
		
		JLabel lblNewLabel_3 = new JLabel("HORA");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(31, 190, 54, 41);
		contentPane.add(lblNewLabel_3);
		
		spinnerMinuto = new JSpinner();
		spinnerMinuto.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto.setBounds(115, 231, 55, 30);
		contentPane.add(spinnerMinuto);
		
		JLabel lblNewLabel_4 = new JLabel("MINUTOS");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(115, 193, 102, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Detalhes:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(248, 38, 112, 30);
		contentPane.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(248, 90, 153, 167);
		contentPane.add(scrollPane);
		
		textAreaDetalhes = new JTextArea();
		textAreaDetalhes.setWrapStyleWord(true);
		textAreaDetalhes.setLineWrap(true);
		scrollPane.setViewportView(textAreaDetalhes);
		
		btnVoltarAoMenu = new JButton("Voltar");
		btnVoltarAoMenu.setBounds(46, 375, 84, 20);
		contentPane.add(btnVoltarAoMenu);
		
		btnAgendar = new JButton("Agendar");
		btnAgendar.setBounds(46, 335, 84, 20);
		contentPane.add(btnAgendar);
		
		btnVoltarAoMenu.addActionListener(e -> voltarParaMenu());
		
		btnAgendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    // Pega criança selecionada
                    Criança criancaSelecionada =
                            (Criança) comboNomeCria.getSelectedItem();

                    if (criancaSelecionada == null) {
                        throw new ExceptionAcesso("Selecione uma criança.");
                    }

                    int dia = (int) spinnerDia.getValue();
                    int mes = (int) spinnerMes.getValue();
                    int hora = (int) spinnerHora.getValue();
                    int minuto = (int) spinnerMinuto.getValue();
                    String detalhes = textAreaDetalhes.getText();

                    controller.agendar(
                            criancaSelecionada,
                            dia,
                            mes,
                            hora,
                            minuto,
                            detalhes
                    );

                    JOptionPane.showMessageDialog(null,
                            "Agendamento realizado com sucesso!");

                } catch (ExceptionAcesso ex) {

                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

	}
	    
	    /*
	     * Método responsável por preencher o JComboBox
	     * com as crianças do mentorado logado.
	     */
	    private void carregarCriancas() {
	    	try {
	        // Busca as crianças pelo mentorado logado
	    		List<Criança> lista = controller.listarCriancasDoMentorado(mentoradoLogado);
	        comboNomeCria.removeAllItems();

	            // Limpa o combo antes de inserir (segurança)
	            comboNomeCria.removeAllItems();

	            // Adiciona cada criança no JComboBox
	            for (Criança c : lista) {
	                comboNomeCria.addItem(c);
	            }

	        } catch (ExceptionAcesso e) {

	            JOptionPane.showMessageDialog(null,
	                    e.getMessage(),
	                    "Erro",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    
	    private void voltarParaMenu() {
	        // Fecha a tela de agendamento
	        this.dispose();

	        // Cria a tela do menu principal passando o mentorado logado
	        ViewMenu menu = new ViewMenu(mentoradoLogado, controller.getCriancaRepository());

	        // Conecta o controller ao menu
	        new ControllerMenu(menu, controller.getCriancaRepository(), mentoradoLogado);

	        // Mostra o menu
	        menu.setVisible(true);
	    }
}
