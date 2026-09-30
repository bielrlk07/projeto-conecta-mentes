package com.conecta_mentes.conectamentes.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

    /*
     * Verifica se já existe um agendamento com a mesma dataHora
     * e com status AGENDADO.
     * 
     * Isso garante que só exista UM agendamento por horário.
     */
    boolean existsByDataHoraAndStatus(LocalDateTime dataHora, StatusAgendamento status);

    // Método que já existe: busca tudo que passou
    List<Agendamento> findByDataHoraBefore(LocalDateTime dataHora);

    // Novo método: busca agendamentos AGENDADOS antes de agora
    List<Agendamento> findByStatusAndDataHoraBefore(StatusAgendamento status, LocalDateTime dataHora);
}
