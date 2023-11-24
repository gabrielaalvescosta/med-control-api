package com.medcontrol.medcontrol.model;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transacao")
public class TransacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medicamento_id", nullable = false)
    private MedicamentoModel medicamento;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private FuncionarioModel funcionario;

    private LocalDate data;
    private BigDecimal quantidade;

}
