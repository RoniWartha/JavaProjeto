package com.webapiseplag.repositories;

import com.webapiseplag.domain.PessoaEndereco;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, PessoaEndereco.PessoaEnderecoId> {

    List<PessoaEndereco> findByPessoaId(Long pessoaId);

    List<PessoaEndereco> findByEnderecoId(Long enderecoId);

    @Transactional
    @Modifying
    @Query("DELETE FROM PessoaEndereco pe WHERE pe.pessoa.id = :pessoaId")
    void deleteAllByPessoaId(Long pessoaId);

    @Transactional
    @Modifying
    @Query("DELETE FROM PessoaEndereco pe WHERE pe.endereco.id = :enderecoId")
    void deleteAllByEnderecoId(Long enderecoId);

    boolean existsByPessoaIdAndEnderecoId(Long pessoaId, Long enderecoId);

    @Query("SELECT pe FROM PessoaEndereco pe WHERE pe.pessoa.id = :pessoaId AND pe.endereco.id = :enderecoId")
    PessoaEndereco findByPessoaIdAndEnderecoId(Long pessoaId, Long enderecoId);

    @Transactional
    @Modifying
    @Query("DELETE FROM PessoaEndereco pe WHERE pe.pessoa.id = :pessoaId AND pe.endereco.id = :enderecoId")
    void deleteByPessoaIdAndEnderecoId(Long pessoaId, Long enderecoId);
}