package com.webapiseplag.repositories;

import com.webapiseplag.domain.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    boolean existsByNome(String nome);
    Page<Pessoa> findAll(Pageable pageable);
    Page<Pessoa> findByNomeContaining(String nome, Pageable pageable);
}