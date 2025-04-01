package com.webapiseplag.repositories;

import com.webapiseplag.domain.ServidorEfetivo;
import com.webapiseplag.dtos.ServidorEfetivoLotacaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivo, Long> {
    boolean existsByMatricula(String matricula);
    boolean existsByPessoaId(Long pessoaId);

    @Query(value = "SELECT p.pes_nome AS nome, " +
            "EXTRACT(YEAR FROM AGE(CURRENT_DATE, p.pes_data_nascimento)) AS idade, " +
            "u.unid_nome AS unidadeLotacao, " +
            "(SELECT fp.fp_bucket FROM foto_pessoa fp WHERE fp.pes_id = p.pes_id ORDER BY fp.fp_data DESC LIMIT 1) AS fotoBucket " +
            "FROM servidor_efetivo se " +
            "JOIN pessoa p ON se.pes_id = p.pes_id " +
            "JOIN lotacao l ON l.pes_id = se.pes_id " +
            "JOIN unidade u ON l.unid_id = u.unid_id " +
            "WHERE u.unid_id = :unidadeId",
            nativeQuery = true)
    List<Object[]> findServidoresEfetivosPorUnidade(@Param("unidadeId") Long unidadeId);
}