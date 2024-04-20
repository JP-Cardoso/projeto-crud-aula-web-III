package com.joao.projetocrud.domain.tarefa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tarefas")
@Entity(name = "tarefas")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String nome;

  private String status;

  private String observacoes;

}