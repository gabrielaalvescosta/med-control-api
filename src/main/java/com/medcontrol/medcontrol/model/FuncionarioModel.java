package com.medcontrol.medcontrol.model;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "funcionario")

public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cargo_id", nullable = false)
    private DepartamentoModel cargo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "funcionario_id", nullable = false)
    private UnidadeTrabalhoModel unidade;

}