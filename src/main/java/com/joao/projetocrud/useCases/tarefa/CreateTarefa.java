package com.joao.projetocrud.useCases.tarefa;

import org.springframework.beans.factory.annotation.Autowired;

import com.joao.projetocrud.domain.tarefa.Tarefa;
import com.joao.projetocrud.domain.tarefa.TarefaDTO;
import com.joao.projetocrud.infra.repositories.tarefa.TarefaRepository;

public class CreateTarefa {

  @Autowired
  TarefaRepository tarefaRepository;

  public Tarefa execute(TarefaDTO data) {
    Tarefa newTarefa = new Tarefa(data);
    this.tarefaRepository.save(newTarefa);
    return newTarefa;
  }
}
