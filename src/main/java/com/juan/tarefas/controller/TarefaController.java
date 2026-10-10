package com.juan.tarefas.controller;

import com.juan.tarefas.dto.TarefaRequestDTO;
import com.juan.tarefas.dto.TarefaResponseDTO;
import com.juan.tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criarTarefa(@RequestBody @Valid TarefaRequestDTO tarefaRequestDTO) {
        return ResponseEntity.status(201).body(tarefaService.criarTarefa(tarefaRequestDTO));
    }

    @GetMapping()
    public ResponseEntity<List<TarefaResponseDTO>> listarTarefa() {
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<TarefaResponseDTO> concluirTarefa(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.concluirTarefa(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> encontrarTarefa(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.encontrarTarefa(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}

