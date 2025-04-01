package com.webapiseplag.repositories;
import com.webapiseplag.domain.Unidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
    boolean existsBySigla(String sigla);
    Page<Unidade> findAll(Pageable pageable);
    Page<Unidade> findByNomeContainingOrSiglaContaining(String nome, String sigla, Pageable pageable);
}
