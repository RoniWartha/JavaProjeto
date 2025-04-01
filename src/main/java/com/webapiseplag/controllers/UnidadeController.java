package com.webapiseplag.controllers;

import com.webapiseplag.domain.Unidade;
import com.webapiseplag.services.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/unidades")
public class UnidadeController {

    private final UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @PostMapping
    public ResponseEntity<Unidade> create(@RequestBody Unidade unidade) {
        Unidade savedUnidade = unidadeService.save(unidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUnidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> getById(@PathVariable Long id) {
        return ResponseEntity.ok(unidadeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<Unidade>> getAll(
            @PageableDefault(size = 10, sort = {"nome"}) Pageable pageable,
            @RequestParam(required = false) String search) {

        if (search != null && !search.isEmpty()) {
            return ResponseEntity.ok(unidadeService.search(search, pageable));
        }
        return ResponseEntity.ok(unidadeService.findAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> update(@PathVariable Long id, @RequestBody Unidade unidade) {
        unidade.setId(id);
        return ResponseEntity.ok(unidadeService.save(unidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        unidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}