package com.conecta_mentes.conectamentes.view;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.conecta_mentes.conectamentes.controller.ControllerAgendamento;
import com.conecta_mentes.conectamentes.controller.ControllerLogin;
import com.conecta_mentes.conectamentes.controller.ControllerMenu;
import com.conecta_mentes.conectamentes.model.*;
 
@Component
public class ViewLogin extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField campoNome;
    private JPasswordField campoSenha;
    private JButton botaoLogar;
    private JButton botaoCadastrar;
    private final ControllerLogin controllerLogin;
    private final ViewCadastro viewCadastro;
    private final CriançaRepository criancaRepository;
    
    @Autowired
    private ControllerAgendamento controllerAgendamento;

    /*
     * Construtor com injeção de dependências.
     * 
     * O Spring injeta automaticamente:
     *  - ControllerLogin
     *  - ViewCadastro
     */
    public ViewLogin(ControllerLogin controllerLogin,
            ViewCadastro viewCadastro,
            CriançaRepository criancaRepository) {
    	getContentPane().setBackground(Color.DARK_GRAY);

		this.controllerLogin = controllerLogin;
		this.viewCadastro = viewCadastro;
		this.criancaRepository = criancaRepository;

        setTitle("Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setForeground(Color.WHITE);
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNome.setBounds(29, 63, 86, 23);
        getContentPane().add(lblNome);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSenha.setBounds(29, 97, 86, 23);
        getContentPane().add(lblSenha);

        JLabel lblTitulo = new JLabel("Login");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 33));
        lblTitulo.setBounds(151, 11, 92, 40);
        getContentPane().add(lblTitulo);

        campoNome = new JTextField();
        campoNome.setBounds(100, 66, 189, 25);
        getContentPane().add(campoNome);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(100, 100, 189, 25);
        getContentPane().add(campoSenha);

        botaoLogar = new JButton("Logar");
        botaoLogar.setBackground(new Color(255, 255, 255));
        botaoLogar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        botaoLogar.setBounds(45, 161, 123, 65);
        getContentPane().add(botaoLogar);
        
        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBackground(new Color(255, 255, 255));
        botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        botaoCadastrar.setBounds(212, 161, 123, 65);
        getContentPane().add(botaoCadastrar);
        
     // BOTÃO LOGAR
        botaoLogar.addActionListener(e -> {
            try {
                String nome = campoNome.getText();
                String senha = new String(campoSenha.getPassword());
                
             // LOGIN FIXO DO ADMINISTRADOR
                if(nome.equalsIgnoreCase("Cristiane") && senha.equals("280602")) {
                    // Abre ViewAdministrador usando Controller já injetado pelo Spring
                    ViewAdministrador viewAdmin = new ViewAdministrador(controllerAgendamento);
                    viewAdmin.setVisible(true);
                    dispose();
                    return;
                }

                // Autenticação do mentorado
                Mentorado mentorado = controllerLogin.autenticar(nome, senha);

                JOptionPane.showMessageDialog(
                        null,
                        "Login realizado com sucesso!\nBem-vindo(a), "
                                + mentorado.getNome(),
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE
                );

                // Cria o menu com o mentorado logado
                ViewMenu menu = new ViewMenu(mentorado, criancaRepository);
                // Conecta o ControllerMenu ao menu e ao mentorado
                new ControllerMenu(menu, criancaRepository, mentorado);

                // Mostra o menu
                menu.setVisible(true);

                // Fecha a tela de login
                dispose();

            } catch (ExceptionAcesso ex) {
                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "Erro de Acesso",
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

        // BOTÃO CADASTRAR
        botaoCadastrar.addActionListener(e -> {
            dispose();
            viewCadastro.setVisible(true);
        });
    }
}