package com.webapiseplag.controllers;

import com.webapiseplag.domain.Cidade;
import com.webapiseplag.services.CidadeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @PostMapping
    public ResponseEntity<Cidade> create(@RequestBody Cidade cidade) {
        Cidade savedCidade = cidadeService.save(cidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<Cidade>> getAll(
            @PageableDefault(size = 20, sort = {"nome"}) Pageable pageable,
            @RequestParam(required = false) String uf,
            @RequestParam(required = false) String nome) {

        if (uf != null && !uf.isEmpty()) {
            return ResponseEntity.ok(cidadeService.findByUf(uf, pageable));
        }
        if (nome != null && !nome.isEmpty()) {
            return ResponseEntity.ok(cidadeService.findByNomeContaining(nome, pageable));
        }
        return ResponseEntity.ok(cidadeService.findAll(pageable));
    }

    @GetMapping("/uf/{uf}")
    public ResponseEntity<List<Cidade>> getByUf(@PathVariable String uf) {
        return ResponseEntity.ok(cidadeService.findByUf(uf));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}