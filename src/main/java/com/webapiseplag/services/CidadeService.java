package com.webapiseplag.services;

import com.webapiseplag.domain.Cidade;
import com.webapiseplag.repositories.CidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    // Métodos não-paginados
    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public List<Cidade> findByUf(String uf) {
        return cidadeRepository.findByUf(uf);
    }

    // Métodos paginados
    public Page<Cidade> findAll(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }

    public Page<Cidade> findByUf(String uf, Pageable pageable) {
        return cidadeRepository.findByUf(uf, pageable);
    }

    public Page<Cidade> findByNomeContaining(String nome, Pageable pageable) {
        return cidadeRepository.findByNomeContainingIgnoreCase(nome, pageable);
    }

    public Page<Cidade> findByUfAndNomeContaining(String uf, String nome, Pageable pageable) {
        return cidadeRepository.findByUfAndNomeContainingIgnoreCase(uf, nome, pageable);
    }

    // Métodos CRUD básicos
    public Cidade findById(Long id) {
        return cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
    }

    @Transactional
    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    @Transactional
    public void delete(Long id) {
        cidadeRepository.deleteById(id);
    }
}