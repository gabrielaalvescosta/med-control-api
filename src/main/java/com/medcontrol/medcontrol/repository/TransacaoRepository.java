package com.medcontrol.medcontrol.repository;

import com.medcontrol.medcontrol.model.TransacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<TransacaoModel, Long> {
    // Métodos específicos, se necessário
}