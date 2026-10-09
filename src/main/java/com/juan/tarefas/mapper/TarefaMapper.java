package com.juan.tarefas.mapper;

import com.juan.tarefas.dto.TarefaRequestDTO;
import com.juan.tarefas.dto.TarefaResponseDTO;
import com.juan.tarefas.model.TarefaModel;
import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {

    public TarefaModel toModel(TarefaRequestDTO tarefaRequestDTO) {

        TarefaModel tarefaModel = new TarefaModel();
        tarefaModel.setTitulo(tarefaRequestDTO.titulo());
        return tarefaModel;
    }

    public TarefaResponseDTO toResponseDTO(TarefaModel tarefa) {
        return new TarefaResponseDTO(tarefa.getId(), tarefa.getTitulo(), tarefa.isConcluido());
    }
}
