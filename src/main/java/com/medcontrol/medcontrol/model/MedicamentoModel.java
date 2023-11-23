package com.medcontrol.medcontrol.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "medicamento")
public class MedicamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

}