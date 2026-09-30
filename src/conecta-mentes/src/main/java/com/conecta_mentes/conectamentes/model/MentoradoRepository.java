package com.conecta_mentes.conectamentes.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository responsável por fazer a comunicação entre a aplicação e o banco de dados para a entidade Mentorado.
 * JpaRepository já fornece métodos prontos de CRUD.
 */
@Repository
public interface MentoradoRepository extends JpaRepository<Mentorado, Long> {
    /*
     * Método personalizado para buscar mentorado pelo nome.
     * O Spring cria automaticamente a query baseada no nome do método.
     */
    Mentorado findByNome(String nome);
    boolean existsByEmail(String email);
}
