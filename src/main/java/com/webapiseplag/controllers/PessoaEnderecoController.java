package com.webapiseplag.controllers;

import com.webapiseplag.domain.PessoaEndereco;
import com.webapiseplag.services.PessoaEnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pessoas-enderecos")
public class PessoaEnderecoController {

    private final PessoaEnderecoService pessoaEnderecoService;

    public PessoaEnderecoController(PessoaEnderecoService pessoaEnderecoService) {
        this.pessoaEnderecoService = pessoaEnderecoService;
    }

    @PostMapping
    public ResponseEntity<PessoaEndereco> create(@RequestBody PessoaEndereco pessoaEndereco) {
        PessoaEndereco saved = pessoaEnderecoService.save(pessoaEndereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<PessoaEndereco>> getByPessoaId(@PathVariable Long pessoaId) {
        return ResponseEntity.ok(pessoaEnderecoService.findByPessoaId(pessoaId));
    }

    @GetMapping("/endereco/{enderecoId}")
    public ResponseEntity<List<PessoaEndereco>> getByEnderecoId(@PathVariable Long enderecoId) {
        return ResponseEntity.ok(pessoaEnderecoService.findByEnderecoId(enderecoId));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long pessoaId, @RequestParam Long enderecoId) {
        pessoaEnderecoService.deleteByPessoaIdAndEnderecoId(pessoaId, enderecoId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/pessoa/{pessoaId}")
    public ResponseEntity<Void> deleteAllByPessoaId(@PathVariable Long pessoaId) {
        pessoaEnderecoService.deleteAllByPessoaId(pessoaId);
        return ResponseEntity.noContent().build();
    }
}