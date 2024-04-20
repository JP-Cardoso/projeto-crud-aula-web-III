package com.joao.projetocrud.infra.repositories.tarefa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.projetocrud.domain.tarefa.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, String> {

  Optional<Tarefa> findByNome(String name);

}