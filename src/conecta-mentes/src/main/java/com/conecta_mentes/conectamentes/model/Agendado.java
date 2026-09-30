package com.conecta_mentes.conectamentes.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.*;

@Component
public class Agendado {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Roda a cada minuto para verificar agendamentos expirados
    @Scheduled(fixedRate = 60000) // 60000 ms = 1 minuto
    public void atualizarAgendamentosExpirados() {
        LocalDateTime agora = LocalDateTime.now();

        // Busca todos os agendamentos AGENDADOS cuja data/hora já passou
        List<Agendamento> expirados = agendamentoRepository
                .findByStatusAndDataHoraBefore(StatusAgendamento.AGENDADO, agora);

        for (Agendamento a : expirados) {
            a.setStatus(StatusAgendamento.EXPIRADO); // Atualiza o status
        }

        if (!expirados.isEmpty()) {
            agendamentoRepository.saveAll(expirados);
            System.out.println(expirados.size() + " agendamento(s) expirado(s) atualizado(s)");
        }
    }
}