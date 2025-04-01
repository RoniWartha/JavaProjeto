package com.webapiseplag.repositories;

import com.webapiseplag.domain.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    // Métodos não-paginados (para compatibilidade ou casos específicos)
    List<Cidade> findAll();
    List<Cidade> findByUf(String uf);

    // Métodos paginados
    Page<Cidade> findAll(Pageable pageable);
    Page<Cidade> findByUf(String uf, Pageable pageable);
    Page<Cidade> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    // Método combinado para busca avançada
    Page<Cidade> findByUfAndNomeContainingIgnoreCase(String uf, String nome, Pageable pageable);
}