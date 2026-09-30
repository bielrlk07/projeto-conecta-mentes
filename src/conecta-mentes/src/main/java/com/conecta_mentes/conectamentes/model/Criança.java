package com.conecta_mentes.conectamentes.model;

import java.util.List;

import jakarta.persistence.*;

@Entity 
@Table(name = "crianca") 
public class Criança {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da criança

    @Column(nullable = false)
    private String nome; // Nome da criança

    @Column(nullable = false)
    private Integer idade; // Idade da criança

    @Column(length = 500)
    private String observacoes; // Observações (opcional)

    // Muitas crianças para um mentorado
    @ManyToOne
    @JoinColumn(name = "mentorado_id", nullable = false)
    private Mentorado mentorado;
    
 // Uma criança pode ter vários agendamentos
    @OneToMany(mappedBy = "crianca", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos;

    public Criança() {
    }

    // Construtor opcional
    public Criança(String nome, Integer idade, String observacoes, Mentorado mentorado) {
        this.nome = nome;
        this.idade = idade;
        this.observacoes = observacoes;
        this.mentorado = mentorado;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new RuntimeException("Nome da criança não pode ser vazio.");
        }
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        if (idade == null || idade <= 0) {
            throw new RuntimeException("Idade inválida.");
        }
        this.idade = idade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Mentorado getMentorado() {
        return mentorado;
    }

    public void setMentorado(Mentorado mentorado) {
        if (mentorado == null) {
            throw new RuntimeException("Criança deve estar vinculada a um mentorado.");
        }
        this.mentorado = mentorado;
    }
}