package com.webapiseplag.services;

import com.webapiseplag.domain.*;
import com.webapiseplag.repositories.LotacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class LotacaoService {

    private final LotacaoRepository lotacaoRepository;

    public LotacaoService(LotacaoRepository lotacaoRepository) {
        this.lotacaoRepository = lotacaoRepository;
    }

    @Transactional
    public Lotacao save(Lotacao lotacao) {
        return lotacaoRepository.save(lotacao);
    }

    public List<Lotacao> findByServidorId(Long servidorId) {
        return lotacaoRepository.findByServidorId(servidorId);
    }

    public List<Lotacao> findByUnidadeId(Long unidadeId) {
        return lotacaoRepository.findByUnidadeId(unidadeId);
    }

    @Transactional
    public void delete(Long id) {
        lotacaoRepository.deleteById(id);
    }

    public Page<Lotacao> findByServidorId(Long servidorId, Pageable pageable) {
        return lotacaoRepository.findByServidorId(servidorId, pageable);
    }

    public Page<Lotacao> findByUnidadeId(Long unidadeId, Pageable pageable) {
        return lotacaoRepository.findByUnidadeId(unidadeId, pageable);
    }
}