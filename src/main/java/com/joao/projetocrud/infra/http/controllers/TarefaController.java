package com.joao.projetocrud.infra.http.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.projetocrud.domain.tarefa.Tarefa;
import com.joao.projetocrud.domain.tarefa.TarefaDTO;
import com.joao.projetocrud.infra.repositories.tarefa.TarefaRepository;
import com.joao.projetocrud.useCases.tarefa.CreateTarefa;
import com.joao.projetocrud.useCases.tarefa.DeleteTarefa;
import com.joao.projetocrud.useCases.tarefa.UpdateTarefa;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

  @Autowired
  TarefaRepository tarefaRepository;

  @Autowired
  CreateTarefa createTarefa;

  @Autowired
  UpdateTarefa updateTarefa;

  @Autowired
  DeleteTarefa deleteTarefa;

  @PostMapping
  public ResponseEntity<Tarefa> criarTarefa(@RequestBody TarefaDTO data) {
    Tarefa newTarefa = this.createTarefa.execute(data);
    return ResponseEntity.ok().body(newTarefa);
  }

  @SuppressWarnings("rawtypes")
  @PutMapping("/{id}")
  public ResponseEntity atualizarTarefa(@PathVariable String id, @RequestBody TarefaDTO data) {
    Object result = this.updateTarefa.execute(id, data);
    if (result == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body("Tarefa atualizada com sucesso!");
  }

  @SuppressWarnings("rawtypes")
  @DeleteMapping("/{id}")
  public ResponseEntity deletarTarefa(@PathVariable String id) {
    Object result = this.deleteTarefa.execute(id);
    if (result == null) {
      return ResponseEntity.ok().body("Tarefa deletada com sucesso!");
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping
  public ResponseEntity<List<Tarefa>> listaTarefas() {
    List<Tarefa> tarefas = this.tarefaRepository.findAll();
    return new ResponseEntity<>(tarefas, HttpStatus.OK);
  }

}