package com.webapiseplag.services;

import com.webapiseplag.domain.Pessoa;
import com.webapiseplag.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    public boolean existsByNome(String nome) {
        return pessoaRepository.existsByNome(nome);
    }

    public Page<Pessoa> findAll(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    public Page<Pessoa> findByNome(String nome, Pageable pageable) {
        return pessoaRepository.findByNomeContaining(nome, pageable);
    }
}
