package com.joao.projetocrud.infra.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.projetocrud.domain.tarefa.Tarefa;
import com.joao.projetocrud.domain.tarefa.TarefaDTO;
import com.joao.projetocrud.useCases.tarefa.CreateTarefa;
import com.joao.projetocrud.useCases.tarefa.UpdateTarefa;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

  @Autowired
  CreateTarefa createTarefa;

  @Autowired
  UpdateTarefa updateTarefa;

  @PostMapping
  public ResponseEntity<Tarefa> criarTarefa(@RequestBody TarefaDTO data) {
    Tarefa newTarefa = this.createTarefa.execute(data);
    return ResponseEntity.ok().body(newTarefa);
  }

  @SuppressWarnings("rawtypes")
  @PutMapping("/{id}")
  public ResponseEntity atualizarTarefa(@PathVariable String id, @RequestBody TarefaDTO data) {
    Object result = this.updateTarefa.execute(id, data);
    System.out.println(id);
    if (result == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().build();
  }

}