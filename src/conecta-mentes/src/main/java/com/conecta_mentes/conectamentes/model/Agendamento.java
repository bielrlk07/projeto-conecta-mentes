package com.conecta_mentes.conectamentes.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do agendamento

    // Data e hora completas do agendamento
    // Usamos LocalDateTime para evitar inconsistências de data/hora separadas
    @Column(nullable = false)
    private LocalDateTime dataHora;

    // Campo opcional para detalhes adicionais
    @Column(length = 500)
    private String detalhes;

    // Status do agendamento (AGENDADO, EXPIRADO)
    @Enumerated(EnumType.STRING) 
    @Column(nullable = false)
    private StatusAgendamento status;

    // Muitos agendamentos para uma criança
    @ManyToOne
    @JoinColumn(name = "crianca_id", nullable = false)
    private Criança crianca;

    public Agendamento() {
    }

    public Agendamento(LocalDateTime dataHora, String detalhes, StatusAgendamento status, Criança crianca) {
        this.dataHora = dataHora;
        this.detalhes = detalhes;
        this.status = status;
        this.crianca = crianca;
    }
    
    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public Criança getCrianca() {
        return crianca;
    }

    public void setCrianca(Criança crianca) {
        this.crianca = crianca;
    }
}