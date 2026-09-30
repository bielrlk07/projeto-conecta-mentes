package com.conecta_mentes.conectamentes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.conecta_mentes.conectamentes.model.*;

//Responsavel pelo cadastro
@Controller
public class ControllerCadastro {

    // Injeção do Repository
    @Autowired
    private MentoradoRepository mentoradoRepository;

    // Método responsável por cadastrar
    public void cadastrarMentorado(
            String nome,
            String senha,
            String email,
            String telefone,
            String endereco,
            int nPessoas,
            String graduacao,
            String formacao,
            SegmentoEnsino segmentoEnsino,
            TipoMentor tipoMentor
    ) {
    	
        // VALIDAÇÕES OBRIGATÓRIAS
        if (nome == null || nome.trim().isEmpty()) {
            throw new ExceptionAcesso("Nome não pode ser vazio.");
        }

        if (senha == null || senha.length() < 6 || senha.length() > 12) {
            throw new ExceptionAcesso("Senha deve ter entre 6 e 12 caracteres.");
        }

        if (email == null || !email.contains("@") || !email.endsWith(".com")) {
            throw new ExceptionAcesso("Email inválido. Deve conter '@' e terminar com '.com'.");
        }

        if (telefone == null || !telefone.matches("\\d{10,11}")) {
            throw new ExceptionAcesso("Telefone deve ter DDD (2 dígitos) + 8 ou 9 números.");
        }

        if (endereco == null || endereco.trim().isEmpty()) {
            throw new ExceptionAcesso("Endereço não pode ser vazio.");
        }

        if (nPessoas < 2) {
            throw new ExceptionAcesso("Número de pessoas deve ser no mínimo 2.");
        }

        if (segmentoEnsino == null) {
            throw new ExceptionAcesso("Segmento de ensino deve ser selecionado.");
        }

        if (tipoMentor == null) {
            throw new ExceptionAcesso("Tipo de mentor deve ser selecionado.");
        }

        if (mentoradoRepository.existsByEmail(email)) {
            throw new ExceptionAcesso("Já existe cadastro com esse email.");
        }

        // Criamos um novo objeto Mentorado

        Mentorado mentorado = new Mentorado();

        mentorado.setNome(nome);
        mentorado.setSenha(senha);
        mentorado.setEmail(email);
        mentorado.setTelefone(telefone);
        mentorado.setEndereco(endereco);
        mentorado.setNPessoas(nPessoas);
        mentorado.setGraduacao(graduacao);
        mentorado.setFormacao(formacao);
        mentorado.setSegmentoEnsino(segmentoEnsino);
        mentorado.setTipoMentor(tipoMentor);


        // Salvamos no banco via JPA
        mentoradoRepository.save(mentorado);

        // O método save() faz:
        // - INSERT no banco se for novo
        // - UPDATE se já existir ID
    }
}
