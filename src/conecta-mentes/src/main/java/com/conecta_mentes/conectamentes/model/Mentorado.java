package com.conecta_mentes.conectamentes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mentorado")
public class Mentorado extends Usuario {

	//  Email do mentor.
    @Column(nullable = false)
    private String email;

    
    //  Telefone do mentor.
    @Column(nullable = false)
    private String telefone;


     // Endereço do mentor.
    @Column(nullable = false)
    private String endereco;


     //Número de pessoas na casa.
    @Column(nullable = false)
    private Integer nPessoas;


     //Graduação do mentor.
    @Column(nullable = true)
    // Pode ser null pois nem todo mentor precisa ter graduação
    private String graduacao;

    
     //Formação complementar.
    @Column(nullable = true)
    // Pode ser null pois nem todo mentor precisa ter formaçao
    private String formacao;

  
     //Segmento de ensino (ENUM).
     //Será armazenado como String no banco.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SegmentoEnsino segmentoEnsino;


     // Tipo de mentor (ENUM).
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMentor tipoMentor;
    
    public Mentorado() {
    	super();
    }
    
    public Mentorado(Long id, String nome, String senha,
            String email, String telefone, String endereco,
            Integer nPessoas, String graduacao, String formacao,
            SegmentoEnsino segmentoEnsino, TipoMentor tipoMentor) {

	super(id, nome, senha); 
	this.email = email;
	this.telefone = telefone;
	this.endereco = endereco;
	this.nPessoas = nPessoas;
	this.graduacao = graduacao;
	this.formacao = formacao;
	this.segmentoEnsino = segmentoEnsino;
	this.tipoMentor = tipoMentor;
	}
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNPessoas() {
        return nPessoas;
    }

    public void setNPessoas(Integer nPessoas) {
        this.nPessoas = nPessoas;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public SegmentoEnsino getSegmentoEnsino() {
        return segmentoEnsino;
    }

    public void setSegmentoEnsino(SegmentoEnsino segmentoEnsino) {
        this.segmentoEnsino = segmentoEnsino;
    }

    public TipoMentor getTipoMentor() {
        return tipoMentor;
    }

    public void setTipoMentor(TipoMentor tipoMentor) {
        this.tipoMentor = tipoMentor;
    }
}
