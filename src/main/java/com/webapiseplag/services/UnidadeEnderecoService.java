package com.webapiseplag.services;

import com.webapiseplag.domain.*;
import com.webapiseplag.repositories.UnidadeEnderecoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UnidadeEnderecoService {

    private final UnidadeEnderecoRepository unidadeEnderecoRepository;

    public UnidadeEnderecoService(UnidadeEnderecoRepository unidadeEnderecoRepository) {
        this.unidadeEnderecoRepository = unidadeEnderecoRepository;
    }

    @Transactional
    public UnidadeEndereco save(UnidadeEndereco unidadeEndereco) {
        return unidadeEnderecoRepository.save(unidadeEndereco);
    }

    public List<UnidadeEndereco> findByUnidadeId(Long unidadeId) {
        return unidadeEnderecoRepository.findByUnidadeId(unidadeId);
    }

    public List<UnidadeEndereco> findByEnderecoId(Long enderecoId) {
        return unidadeEnderecoRepository.findByEnderecoId(enderecoId);
    }

    @Transactional
    public void deleteByUnidadeIdAndEnderecoId(Long unidadeId, Long enderecoId) {
        if (unidadeEnderecoRepository.existsByUnidadeIdAndEnderecoId(unidadeId, enderecoId)) {
            unidadeEnderecoRepository.deleteByUnidadeIdAndEnderecoId(unidadeId, enderecoId);
        }
    }

    @Transactional
    public void deleteAllByUnidadeId(Long unidadeId) {
        unidadeEnderecoRepository.deleteAllByUnidadeId(unidadeId);
    }

    public boolean existsByUnidadeIdAndEnderecoId(Long unidadeId, Long enderecoId) {
        return unidadeEnderecoRepository.existsByUnidadeIdAndEnderecoId(unidadeId, enderecoId);
    }

    public UnidadeEndereco findByUnidadeIdAndEnderecoId(Long unidadeId, Long enderecoId) {
        return unidadeEnderecoRepository.findByUnidadeIdAndEnderecoId(unidadeId, enderecoId);
    }
}