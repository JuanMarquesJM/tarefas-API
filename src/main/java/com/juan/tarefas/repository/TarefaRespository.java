package com.juan.tarefas.repository;

import com.juan.tarefas.model.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRespository extends JpaRepository<TarefaModel, Long> {
}
