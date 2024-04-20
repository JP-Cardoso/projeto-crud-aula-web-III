package com.joao.projetocrud.domain.tarefa;

public record TarefaDTO(
    String id,
    String nome,
    String status,
    String observacoes) {
}
