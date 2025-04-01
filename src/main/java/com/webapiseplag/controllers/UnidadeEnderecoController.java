package com.webapiseplag.controllers;

import com.webapiseplag.domain.UnidadeEndereco;
import com.webapiseplag.services.UnidadeEnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/unidades-enderecos")
public class UnidadeEnderecoController {

    private final UnidadeEnderecoService unidadeEnderecoService;

    public UnidadeEnderecoController(UnidadeEnderecoService unidadeEnderecoService) {
        this.unidadeEnderecoService = unidadeEnderecoService;
    }

    @PostMapping
    public ResponseEntity<UnidadeEndereco> create(@RequestBody UnidadeEndereco unidadeEndereco) {
        UnidadeEndereco saved = unidadeEnderecoService.save(unidadeEndereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/unidade/{unidadeId}")
    public ResponseEntity<List<UnidadeEndereco>> getByUnidadeId(@PathVariable Long unidadeId) {
        return ResponseEntity.ok(unidadeEnderecoService.findByUnidadeId(unidadeId));
    }

    @GetMapping("/endereco/{enderecoId}")
    public ResponseEntity<List<UnidadeEndereco>> getByEnderecoId(@PathVariable Long enderecoId) {
        return ResponseEntity.ok(unidadeEnderecoService.findByEnderecoId(enderecoId));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long unidadeId, @RequestParam Long enderecoId) {
        unidadeEnderecoService.deleteByUnidadeIdAndEnderecoId(unidadeId, enderecoId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/unidade/{unidadeId}")
    public ResponseEntity<Void> deleteAllByUnidadeId(@PathVariable Long unidadeId) {
        unidadeEnderecoService.deleteAllByUnidadeId(unidadeId);
        return ResponseEntity.noContent().build();
    }
}