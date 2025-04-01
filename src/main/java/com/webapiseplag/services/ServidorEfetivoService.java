package com.webapiseplag.services;

import com.webapiseplag.domain.*;
import com.webapiseplag.dtos.ServidorEfetivoLotacaoDTO;
import com.webapiseplag.repositories.ServidorEfetivoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServidorEfetivoService {

    private final ServidorEfetivoRepository servidorEfetivoRepository;

    public ServidorEfetivoService(ServidorEfetivoRepository servidorEfetivoRepository) {
        this.servidorEfetivoRepository = servidorEfetivoRepository;
    }

    @Transactional
    public ServidorEfetivo save(ServidorEfetivo servidorEfetivo) {
        if (servidorEfetivoRepository.existsByMatricula(servidorEfetivo.getMatricula())) {
            throw new RuntimeException("Matrícula já cadastrada");
        }
        return servidorEfetivoRepository.save(servidorEfetivo);
    }

    public ServidorEfetivo findByPessoaId(Long pessoaId) {
        return servidorEfetivoRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Servidor efetivo não encontrado"));
    }

    @Transactional
    public void delete(Long pessoaId) {
        servidorEfetivoRepository.deleteById(pessoaId);
    }

    public boolean existsByMatricula(String matricula) {
        return servidorEfetivoRepository.existsByMatricula(matricula);
    }

    public boolean existsByPessoaId(Long pessoaId) {
        return servidorEfetivoRepository.existsByPessoaId(pessoaId);
    }

    public List<ServidorEfetivoLotacaoDTO> listarServidoresEfetivosPorUnidade(Long unidadeId) {
        List<Object[]> resultados = servidorEfetivoRepository.findServidoresEfetivosPorUnidade(unidadeId);

        return resultados.stream()
                .map(this::mapearParaDTO)
                .collect(Collectors.toList());
    }

    private ServidorEfetivoLotacaoDTO mapearParaDTO(Object[] resultado) {
        Pessoa pessoa = (Pessoa) resultado[0];
        Unidade unidade = (Unidade) resultado[1];
        FotoPessoa foto = (FotoPessoa) resultado[2];

        return new ServidorEfetivoLotacaoDTO(
                pessoa.getNome(),
                calcularIdade(pessoa.getDataNascimento()),
                unidade.getNome(),
                foto != null ? foto.getBucket() : null
        );
    }

    private Integer calcularIdade(Date dataNascimento) {
        if (dataNascimento == null) return null;

        // Converter java.util.Date para LocalDate
        Instant instant = dataNascimento.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate dataNasc = instant.atZone(zoneId).toLocalDate();

        // Calcular a idade
        return Period.between(dataNasc, LocalDate.now()).getYears();
    }
}
