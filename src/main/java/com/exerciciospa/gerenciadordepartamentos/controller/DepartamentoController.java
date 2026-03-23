package com.exerciciospa.gerenciadordepartamentos.controller;

import com.exerciciospa.gerenciadordepartamentos.entity.Departamento;
import com.exerciciospa.gerenciadordepartamentos.service.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Departamento> criar(@RequestBody Departamento departamento) {
        return ResponseEntity.status(201).body(service.salvar(departamento));
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}