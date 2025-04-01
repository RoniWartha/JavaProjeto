package com.webapiseplag.controllers;

import com.webapiseplag.domain.ServidorEfetivo;
import com.webapiseplag.dtos.ServidorEfetivoLotacaoDTO;
import com.webapiseplag.services.ServidorEfetivoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servidores-efetivos")
public class ServidorEfetivoController {

    private final ServidorEfetivoService servidorEfetivoService;

    public ServidorEfetivoController(ServidorEfetivoService servidorEfetivoService) {
        this.servidorEfetivoService = servidorEfetivoService;
    }

    @PostMapping
    public ResponseEntity<ServidorEfetivo> create(@RequestBody ServidorEfetivo servidorEfetivo) {
        ServidorEfetivo savedServidor = servidorEfetivoService.save(servidorEfetivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServidor);
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<ServidorEfetivo> getByPessoaId(@PathVariable Long pessoaId) {
        return ResponseEntity.ok(servidorEfetivoService.findByPessoaId(pessoaId));
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<Void> delete(@PathVariable Long pessoaId) {
        servidorEfetivoService.delete(pessoaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/lotados-unidade/{unidadeId}")
    public ResponseEntity<List<ServidorEfetivoLotacaoDTO>> listarServidoresEfetivosLotados(
            @PathVariable Long unidadeId) {

        List<ServidorEfetivoLotacaoDTO> servidores = servidorEfetivoService
                .listarServidoresEfetivosPorUnidade(unidadeId);

        return ResponseEntity.ok(servidores);
    }
}