package com.medcontrol.medcontrol.repository;

import com.medcontrol.medcontrol.model.UnidadeTrabalhoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends JpaRepository<UnidadeTrabalhoModel, Long> {
    // Adicione métodos personalizados do repositório, se necessário
}