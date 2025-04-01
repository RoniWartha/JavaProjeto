package com.webapiseplag.controllers;

import com.webapiseplag.domain.Lotacao;
import com.webapiseplag.services.LotacaoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lotacoes")
public class LotacaoController {

    private final LotacaoService lotacaoService;

    public LotacaoController(LotacaoService lotacaoService) {
        this.lotacaoService = lotacaoService;
    }

    @PostMapping
    public ResponseEntity<Lotacao> create(@RequestBody Lotacao lotacao) {
        Lotacao savedLotacao = lotacaoService.save(lotacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLotacao);
    }

    @GetMapping("/servidor/{servidorId}")
    public ResponseEntity<Page<Lotacao>> getByServidorId(
            @PathVariable Long servidorId,
            @PageableDefault(size = 10, sort = {"dataLotacao"}) Pageable pageable) {
        return ResponseEntity.ok(lotacaoService.findByServidorId(servidorId, pageable));
    }

    @GetMapping("/unidade/{unidadeId}")
    public ResponseEntity<Page<Lotacao>> getByUnidadeId(
            @PathVariable Long unidadeId,
            @PageableDefault(size = 10, sort = {"dataLotacao"}) Pageable pageable) {
        return ResponseEntity.ok(lotacaoService.findByUnidadeId(unidadeId, pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lotacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}