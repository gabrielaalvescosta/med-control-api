package com.medcontrol.medcontrol.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Outros campos da entidade

    // Construtores, getters e setters

}