package com.medcontrol.medcontrol.repository;

import com.medcontrol.medcontrol.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
    // Métodos específicos, se necessário
}