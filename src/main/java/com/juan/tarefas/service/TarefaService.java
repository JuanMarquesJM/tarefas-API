package com.juan.tarefas.service;

import com.juan.tarefas.dto.TarefaRequestDTO;
import com.juan.tarefas.dto.TarefaResponseDTO;
import com.juan.tarefas.exception.TarefaNaoEncontradaException;
import com.juan.tarefas.mapper.TarefaMapper;
import com.juan.tarefas.model.TarefaModel;
import com.juan.tarefas.repository.TarefaRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRespository tarefaRespository;
    private final TarefaMapper tarefaMapper;

    public TarefaService(TarefaRespository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRespository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    public TarefaResponseDTO criarTarefa(TarefaRequestDTO tarefaRequestDTO) {
        TarefaModel tarefa = tarefaMapper.toModel(tarefaRequestDTO);
        TarefaModel tarefaModel = tarefaRespository.save(tarefa);
        return tarefaMapper.toResponseDTO(tarefaModel);
    }

    public List<TarefaResponseDTO> listarTarefas() {
        return tarefaRespository.findAll().stream()
                .map(tarefaMapper::toResponseDTO)
                .toList();
    }

    public TarefaResponseDTO concluirTarefa(Long id) {
        TarefaModel tarefa = tarefaRespository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
        tarefa.setConcluido(true);
        return tarefaMapper.toResponseDTO(tarefaRespository.save(tarefa));
    }

    public TarefaResponseDTO encontrarTarefa(Long id) {
        TarefaModel tarefa = tarefaRespository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
        return tarefaMapper.toResponseDTO(tarefa);
    }

    public void deletarTarefa(Long id) {
        tarefaRespository.deleteById(id);
    }

}

