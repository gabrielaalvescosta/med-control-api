package com.medcontrol.medcontrol.model;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "unidade_de_trabalho")
public class UnidadeTrabalhoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "unidade")
    private List<FuncionarioModel> funcionarios;

}