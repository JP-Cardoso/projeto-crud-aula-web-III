package com.joao.projetocrud.intra.repositories;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.joao.projetocrud.domain.tarefa.Tarefa;
import com.joao.projetocrud.domain.tarefa.TarefaDTO;
import com.joao.projetocrud.infra.repositories.tarefa.TarefaRepository;

import static org.assertj.core.api.Assertions.assertThat;


import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class TarefaReposiotyTest {

  @Autowired
  TarefaRepository tarefaRepository;

  @Autowired
  EntityManager entityManager;

  @Test
  @DisplayName("deve salvar uma tarefa no banco de dados")
  void devCriarTarefa() {
    TarefaDTO data = new TarefaDTO("Lavar louça", "pendente", "Se não lavar morre");
    this.criarTarefa(data);
    Optional<Tarefa> result = this.tarefaRepository.findByNome("Lavar louça");
    System.out.println(result);
    assertThat(result.isPresent()).isTrue();
  }

  @Test
  @DisplayName("deve retornar vazio quando a tarefa não existir")
  void deveRetornarVazioQuandoATarefaNaoExistir() {
    Optional<Tarefa> result = this.tarefaRepository.findByNome("null");
    assertThat(result.isPresent()).isFalse();
  }

  private Tarefa criarTarefa(TarefaDTO data) {
    Tarefa novaTarefa = new Tarefa(data);
    this.entityManager.persist(novaTarefa);
    return novaTarefa;
  }

}
