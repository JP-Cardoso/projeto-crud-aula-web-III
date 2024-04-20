package com.joao.projetocrud.infra.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.projetocrud.domain.tarefa.Tarefa;
import com.joao.projetocrud.domain.tarefa.TarefaDTO;
import com.joao.projetocrud.useCases.tarefa.CreateTarefa;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

  @Autowired
  CreateTarefa createTarefa;

  @PostMapping
  public ResponseEntity<Tarefa> criarTarefa(@RequestBody TarefaDTO data) {
    Tarefa newTarefa = this.createTarefa.execute(data);
    return ResponseEntity.ok().body(newTarefa);
  }

}