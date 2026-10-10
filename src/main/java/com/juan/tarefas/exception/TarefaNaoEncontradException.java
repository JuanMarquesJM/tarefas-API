package com.juan.tarefas.exception;

public class TarefaNaoEncontradException extends RuntimeException {
    public TarefaNaoEncontradException(Long id) {
        super("Tarefa não encontrada com o id: " + id);
    }
}
