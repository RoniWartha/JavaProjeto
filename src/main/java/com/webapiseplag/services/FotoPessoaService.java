package com.webapiseplag.services;

import com.webapiseplag.domain.FotoPessoa;
import com.webapiseplag.repositories.FotoPessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FotoPessoaService {

    private final FotoPessoaRepository fotoPessoaRepository;

    public FotoPessoaService(FotoPessoaRepository fotoPessoaRepository) {
        this.fotoPessoaRepository = fotoPessoaRepository;
    }

    @Transactional
    public FotoPessoa save(FotoPessoa fotoPessoa) {
        return fotoPessoaRepository.save(fotoPessoa);
    }

    @Transactional
    public void deleteByPessoaId(Long pessoaId) {
        fotoPessoaRepository.deleteByPessoaId(pessoaId);
    }
}
