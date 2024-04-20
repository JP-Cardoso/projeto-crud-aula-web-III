package com.joao.projetocrud.domain.tarefa;

import java.time.LocalDateTime;

public record TarefaDTO(
    String id,
    String nome,
    String status,
    String observacoes,
    LocalDateTime dataCriacao,
    LocalDateTime dataAtualizacao) {
}
