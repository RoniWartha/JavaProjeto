package com.webapiseplag.repositories;

import com.webapiseplag.domain.Lotacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LotacaoRepository extends JpaRepository<Lotacao, Long> {
    List<Lotacao> findByServidorId(Long servidorId);
    List<Lotacao> findByUnidadeId(Long unidadeId);
    Page<Lotacao> findByServidorId(Long servidorId, Pageable pageable);
    Page<Lotacao> findByUnidadeId(Long unidadeId, Pageable pageable);
}
