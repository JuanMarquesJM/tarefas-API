package com.juan.tarefas.dto;

import jakarta.validation.constraints.NotBlank;

public record TarefaRequestDTO(
        @NotBlank(message = "Não pode ser um titulo vazio")
        String titulo
) {}
