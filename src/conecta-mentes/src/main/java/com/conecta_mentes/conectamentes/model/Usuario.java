package com.conecta_mentes.conectamentes.model;

import jakarta.persistence.*; 

@Entity // Indica que essa classe é uma entidade do banco
@Table(name = "usuario") // Nome da tabela no PostgreSQL
@Inheritance(strategy = InheritanceType.JOINED) 
// Estratégia JOINED -> cria uma tabela para Usuario e outra para Mentorado
// Ambas ligadas pelo mesmo ID


public abstract class Usuario {

	//Chave primária da entidade.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // IDENTITY -> usa auto incremento do PostgreSQL
    private Long id;

    //Nome do usuário (usado para login).
    @Column(nullable = false)
    // nullable = false -> campo obrigatório no banco
    private String nome;
    
    //Senha do usuário (usada para login).
    @Column(nullable = false)
    private String senha;
    
    public Usuario() {
    	
    }
    
    public Usuario(Long id, String nome, String senha) {
		this.id=id;
		this.nome=nome;
		this.senha=senha;
	}
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}