package com.joao.projetocrud.useCases.tarefa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.projetocrud.domain.tarefa.Tarefa;
import com.joao.projetocrud.infra.repositories.tarefa.TarefaRepository;

import jakarta.transaction.Transactional;

@Service
public class DeleteTarefa {

  @Autowired
  TarefaRepository tarefaRepository;

  @Transactional
  public Object execute(String id) {
    Optional<Tarefa> tarefa = this.tarefaRepository.findById(id);
    if(tarefa.isPresent()) {
      tarefa.get().setStatus("Inativa");
    }
    return null;
  }
  
}
