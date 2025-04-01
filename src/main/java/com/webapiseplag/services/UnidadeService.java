package com.webapiseplag.services;

import com.webapiseplag.domain.Unidade;
import com.webapiseplag.repositories.UnidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UnidadeService {

    private final UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    @Transactional
    public Unidade save(Unidade unidade) {
        if (unidadeRepository.existsBySigla(unidade.getSigla())) {
            throw new RuntimeException("Sigla já cadastrada");
        }
        return unidadeRepository.save(unidade);
    }

    public Unidade findById(Long id) {
        return unidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidade não encontrada"));
    }

    public List<Unidade> findAll() {
        return unidadeRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        unidadeRepository.deleteById(id);
    }

    public boolean existsBySigla(String sigla) {
        return unidadeRepository.existsBySigla(sigla);
    }

    public Page<Unidade> findAll(Pageable pageable) {
        return unidadeRepository.findAll(pageable);
    }

    public Page<Unidade> search(String termo, Pageable pageable) {
        return unidadeRepository.findByNomeContainingOrSiglaContaining(termo, termo, pageable);
    }
}