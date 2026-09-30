package com.conecta_mentes.conectamentes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.conecta_mentes.conectamentes.model.*;


 //Controller responsável pelo login
@Controller
public class ControllerLogin {

    // Injeção do repositório para acessar o banco
    @Autowired
    private MentoradoRepository repository;

    /*
     * Método responsável por autenticar o usuário.
     * 
     * Recebe:
     *  - nome digitado
     *  - senha digitada
     * 
     * Retorna:
     *  - objeto Mentorado autenticado
     */
    public Mentorado autenticar(String nome, String senha) {

        if (nome == null || nome.isBlank()) {
            throw new ExceptionAcesso("O nome não pode estar vazio.");
        }

        if (senha == null || senha.isBlank()) {
            throw new ExceptionAcesso("A senha não pode estar vazia.");
        }


        // BUSCA NO BANCO
        Mentorado mentorado = repository.findByNome(nome);

        if (mentorado == null) {
            throw new ExceptionAcesso("Usuário não encontrado.");
        }

       
        //  VALIDA SENHA
        if (!mentorado.getSenha().equals(senha)) {
            throw new ExceptionAcesso("Senha incorreta.");
        }
        
        return mentorado;
    }
}