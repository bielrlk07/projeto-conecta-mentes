package com.conecta_mentes.conectamentes.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriançaRepository extends JpaRepository<Criança, Long> {

    // Buscar todas as crianças de um mentorado específico
    List<Criança> findByMentorado(Mentorado mentorado);
}