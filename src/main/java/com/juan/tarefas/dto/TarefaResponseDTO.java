package com.juan.tarefas.dto;

public record TarefaResponseDTO(
        Long id,
        String titulo,
        boolean concluido
){}
