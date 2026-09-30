package com.conecta_mentes.conectamentes.view;

import java.awt.EventQueue;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.conecta_mentes.conectamentes.controller.ControllerAgendamento;
import com.conecta_mentes.conectamentes.model.*;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class ViewAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableListaAgend;
	 private DefaultTableModel tableModel;

	    // Controller responsável por fornecer os dados
	    private ControllerAgendamento controller;
	    private JButton btnAtualizar;

	    public ViewAdministrador(ControllerAgendamento controller) {
	    this.controller = controller; // injetado na criação da tela
	    
		setTitle("Lista de Agendamentos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(10, 10, 613, 517);
		contentPane.add(scrollPane);
		
		tableListaAgend = new JTable();
		tableListaAgend.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableListaAgend.setRowHeight(25);
		scrollPane.setViewportView(tableListaAgend);

		// Colunas do JTable
        String[] colunas = {"ID", "Nome da Criança", "Data", "Hora", "Detalhes", "Status"};
        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // células não editáveis
            }
        };
        tableListaAgend.setModel(tableModel);
        
     // Centralizar cabeçalho
        DefaultTableCellRenderer headerRenderer = 
                (DefaultTableCellRenderer) tableListaAgend.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        scrollPane.setViewportView(tableListaAgend);
        
        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(87, 531, 84, 20);
        contentPane.add(btnAtualizar);
        btnAtualizar.addActionListener(e -> atualizarTabela());
        
        // Popula a tabela na inicialização
        atualizarTabela();
	}
	    
	    // Atualiza a tabela chamando o Controller
	    private void atualizarTabela() {
	        List<Agendamento> lista = controller.getAgendamentoRepository().findAll();
	        popularTabela(lista);
	    }
	    
	 // Popula o JTable com os dados do banco
	    private void popularTabela(List<Agendamento> listaAgendamentos) {
	        tableModel.setRowCount(0); // limpa antes de preencher

	        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        DateTimeFormatter hrFormatter = DateTimeFormatter.ofPattern("HH:mm");

	        for (Agendamento a : listaAgendamentos) {
	            Object[] linha = {
	                    a.getId(),
	                    a.getCrianca().getNome(),
	                    a.getDataHora().format(dtFormatter),
	                    a.getDataHora().format(hrFormatter),
	                    a.getDetalhes() != null ? a.getDetalhes() : "",
	                    a.getStatus().name()
	            };
	            tableModel.addRow(linha);
	        }
	    }

}
