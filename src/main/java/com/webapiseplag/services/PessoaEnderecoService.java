package com.webapiseplag.services;

import com.webapiseplag.domain.*;
import com.webapiseplag.repositories.PessoaEnderecoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PessoaEnderecoService {

    private final PessoaEnderecoRepository pessoaEnderecoRepository;

    public PessoaEnderecoService(PessoaEnderecoRepository pessoaEnderecoRepository) {
        this.pessoaEnderecoRepository = pessoaEnderecoRepository;
    }

    @Transactional
    public PessoaEndereco save(PessoaEndereco pessoaEndereco) {
        return pessoaEnderecoRepository.save(pessoaEndereco);
    }

    public List<PessoaEndereco> findByPessoaId(Long pessoaId) {
        return pessoaEnderecoRepository.findByPessoaId(pessoaId);
    }

    public List<PessoaEndereco> findByEnderecoId(Long enderecoId) {
        return pessoaEnderecoRepository.findByEnderecoId(enderecoId);
    }

    @Transactional
    public void deleteByPessoaIdAndEnderecoId(Long pessoaId, Long enderecoId) {
        // Primeiro verifica se existe o relacionamento
        if (pessoaEnderecoRepository.existsByPessoaIdAndEnderecoId(pessoaId, enderecoId)) {
            pessoaEnderecoRepository.deleteByPessoaIdAndEnderecoId(pessoaId, enderecoId);
        }
    }

    @Transactional
    public void deleteAllByPessoaId(Long pessoaId) {
        pessoaEnderecoRepository.deleteAllByPessoaId(pessoaId);
    }

    public boolean existsByPessoaIdAndEnderecoId(Long pessoaId, Long enderecoId) {
        return pessoaEnderecoRepository.existsByPessoaIdAndEnderecoId(pessoaId, enderecoId);
    }

    public PessoaEndereco findByPessoaIdAndEnderecoId(Long pessoaId, Long enderecoId) {
        return pessoaEnderecoRepository.findByPessoaIdAndEnderecoId(pessoaId, enderecoId);
    }
}