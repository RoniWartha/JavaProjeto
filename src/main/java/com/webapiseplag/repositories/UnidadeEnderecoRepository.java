package com.webapiseplag.repositories;

import com.webapiseplag.domain.UnidadeEndereco;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UnidadeEnderecoRepository extends JpaRepository<UnidadeEndereco, UnidadeEndereco.UnidadeEnderecoId> {

    List<UnidadeEndereco> findByUnidadeId(Long unidadeId);

    List<UnidadeEndereco> findByEnderecoId(Long enderecoId);

    @Transactional
    @Modifying
    @Query("DELETE FROM UnidadeEndereco ue WHERE ue.unidade.id = :unidadeId")
    void deleteAllByUnidadeId(Long unidadeId);

    @Transactional
    @Modifying
    @Query("DELETE FROM UnidadeEndereco ue WHERE ue.endereco.id = :enderecoId")
    void deleteAllByEnderecoId(Long enderecoId);

    boolean existsByUnidadeIdAndEnderecoId(Long unidadeId, Long enderecoId);

    @Query("SELECT ue FROM UnidadeEndereco ue WHERE ue.unidade.id = :unidadeId AND ue.endereco.id = :enderecoId")
    UnidadeEndereco findByUnidadeIdAndEnderecoId(Long unidadeId, Long enderecoId);

    @Transactional
    @Modifying
    @Query("DELETE FROM UnidadeEndereco ue WHERE ue.unidade.id = :unidadeId AND ue.endereco.id = :enderecoId")
    void deleteByUnidadeIdAndEnderecoId(Long unidadeId, Long enderecoId);
}