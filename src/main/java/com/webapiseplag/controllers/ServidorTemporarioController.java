package com.webapiseplag.controllers;

import com.webapiseplag.domain.ServidorTemporario;
import com.webapiseplag.services.ServidorTemporarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servidores-temporarios")
public class ServidorTemporarioController {

    private final ServidorTemporarioService servidorTemporarioService;

    public ServidorTemporarioController(ServidorTemporarioService servidorTemporarioService) {
        this.servidorTemporarioService = servidorTemporarioService;
    }

    @PostMapping
    public ResponseEntity<ServidorTemporario> create(@RequestBody ServidorTemporario servidorTemporario) {
        ServidorTemporario savedServidor = servidorTemporarioService.save(servidorTemporario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServidor);
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<ServidorTemporario> getByPessoaId(@PathVariable Long pessoaId) {
        return ResponseEntity.ok(servidorTemporarioService.findByPessoaId(pessoaId));
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<Void> delete(@PathVariable Long pessoaId) {
        servidorTemporarioService.delete(pessoaId);
        return ResponseEntity.noContent().build();
    }
}