package com.medcontrol.medcontrol.repository;
import com.medcontrol.medcontrol.model.MedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoModel, Long> {
    // Métodos específicos, se necessário
}