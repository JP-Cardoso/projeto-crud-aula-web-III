package com.joao.projetocrud.domain.tarefa;

public record TarefaDTO(
    String nome,
    String status,
    String observacoes,
    String descricao) {
}
