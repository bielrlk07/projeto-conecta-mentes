package com.conecta_mentes.conectamentes.controller;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.conecta_mentes.conectamentes.model.*;

@Controller
public class ControllerAgendamento {
	
	@Autowired
    private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private CriançaRepository criancaRepository;

   //Método responsável por criar um agendamento.    
    public void agendar(Criança crianca,
                        int dia,
                        int mes,
                        int hora,
                        int minuto,
                        String detalhes) {

        LocalDateTime dataHora;

     
        // Validação de data inválida
        try {
            // Ano fixo definido como 2026 conforme decisão do projeto
            dataHora = LocalDateTime.of(2026, mes, dia, hora, minuto);
        } catch (DateTimeException e) {
            throw new ExceptionAcesso("Data inválida para o mês selecionado.");
        }


        // Não permitir data no passado
        if (dataHora.isBefore(LocalDateTime.now())) {
            throw new ExceptionAcesso("Não é possível agendar para data/horário no passado.");
        }


        // Bloqueio de horário
        // Permitido apenas entre 14:00 e 18:00
//        if (hora < 14 || hora >= 18) {
//            throw new ExceptionAcesso("Horário disponível apenas entre 14:00 e 18:00.");
//        }

        // Verificação de conflito
        // Só pode existir UM agendamento por horário
        boolean conflito = agendamentoRepository
                .existsByDataHoraAndStatus(dataHora, StatusAgendamento.AGENDADO);

        if (conflito) {
            throw new ExceptionAcesso("Já existe um agendamento para este horário.");
        }

        // Criação do Agendamento
        Agendamento agendamento = new Agendamento();
        agendamento.setCrianca(crianca);
        agendamento.setDataHora(dataHora);
        agendamento.setDetalhes(detalhes);
        agendamento.setStatus(StatusAgendamento.AGENDADO);

        agendamentoRepository.save(agendamento);
    }
    
    /*
     * Retorna a lista de crianças pertencentes ao mentorado logado.
     * 
     * Essa lista será usada para preencher o JComboBox da View.
     */
    public List<Criança> listarCriancasDoMentorado(Mentorado mentorado) {

        if (mentorado == null) {
            throw new ExceptionAcesso("Mentorado não identificado.");
        }

        // Busca no banco apenas as crianças vinculadas ao mentorado
        return criancaRepository.findByMentorado(mentorado);
    }
    
    public CriançaRepository getCriancaRepository() {
        return this.criancaRepository;
    }
    
    public AgendamentoRepository getAgendamentoRepository() {
        return this.agendamentoRepository;
    }
}

