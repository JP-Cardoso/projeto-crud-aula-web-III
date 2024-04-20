package com.joao.projetocrud.useCases.tarefa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joao.projetocrud.domain.tarefa.Tarefa;
import com.joao.projetocrud.domain.tarefa.TarefaDTO;
import com.joao.projetocrud.infra.repositories.tarefa.TarefaRepository;

@Service
public class UpdateTarefa {

  @Autowired
  TarefaRepository tarefaRepository;

  @Transactional
  public  Object execute(String id, TarefaDTO data) {
    Tarefa result = retornaTarefa(id);
    if (result != null) {
      result.setNome(data.nome());
      result.setObservacoes(data.observacoes());
      result.setStatus(data.status());
    } else {
      throw new RuntimeException("Tarefa não encontrada para o ID");
    }
    return result;
  }

  private Tarefa retornaTarefa(String id) {
    Optional<Tarefa> result = this.tarefaRepository.findById(id);
    if (result.isPresent()) {
      System.out.println(result.get());
      return result.get();
    }
    return null;
  }
}
