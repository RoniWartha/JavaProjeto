package com.webapiseplag.services;

import com.webapiseplag.domain.*;
import com.webapiseplag.repositories.ServidorTemporarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServidorTemporarioService {

    private final ServidorTemporarioRepository servidorTemporarioRepository;

    public ServidorTemporarioService(ServidorTemporarioRepository servidorTemporarioRepository) {
        this.servidorTemporarioRepository = servidorTemporarioRepository;
    }

    @Transactional
    public ServidorTemporario save(ServidorTemporario servidorTemporario) {
        return servidorTemporarioRepository.save(servidorTemporario);
    }

    public ServidorTemporario findByPessoaId(Long pessoaId) {
        return servidorTemporarioRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Servidor temporário não encontrado"));
    }

    @Transactional
    public void delete(Long pessoaId) {
        servidorTemporarioRepository.deleteById(pessoaId);
    }

    public boolean existsByPessoaId(Long pessoaId) {
        return servidorTemporarioRepository.existsByPessoaId(pessoaId);
    }
}