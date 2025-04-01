package com.webapiseplag.controllers;

import com.webapiseplag.domain.FotoPessoa;
import com.webapiseplag.services.FotoPessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fotos-pessoa")
public class FotoPessoaController {

    private final FotoPessoaService fotoPessoaService;

    public FotoPessoaController(FotoPessoaService fotoPessoaService) {
        this.fotoPessoaService = fotoPessoaService;
    }

    @PostMapping
    public ResponseEntity<FotoPessoa> create(@RequestBody FotoPessoa fotoPessoa) {
        FotoPessoa savedFoto = fotoPessoaService.save(fotoPessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFoto);
    }

    @DeleteMapping("/pessoa/{pessoaId}")
    public ResponseEntity<Void> deleteByPessoaId(@PathVariable Long pessoaId) {
        fotoPessoaService.deleteByPessoaId(pessoaId);
        return ResponseEntity.noContent().build();
    }
}