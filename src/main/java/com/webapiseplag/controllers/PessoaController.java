package com.webapiseplag.controllers;

import com.webapiseplag.domain.Pessoa;
import com.webapiseplag.services.PessoaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa) {
        Pessoa savedPessoa = pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<Pessoa>> getAll(
            @PageableDefault(size = 10, sort = {"nome"}) Pageable pageable,
            @RequestParam(required = false) String nome) {

        if (nome != null && !nome.isEmpty()) {
            return ResponseEntity.ok(pessoaService.findByNome(nome, pageable));
        }
        return ResponseEntity.ok(pessoaService.findAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        return ResponseEntity.ok(pessoaService.save(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}