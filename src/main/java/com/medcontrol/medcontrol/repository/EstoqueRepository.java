package com.medcontrol.medcontrol.repository;

import com.medcontrol.medcontrol.model.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel, Long> {

}