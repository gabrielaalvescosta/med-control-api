package com.medcontrol.medcontrol.model;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "unidade_de_trabalho")
public class UnidadeDeTrabalhoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "unidade")
    private List<FuncionarioModel> funcionarios;

}