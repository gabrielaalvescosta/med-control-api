package com.medcontrol.medcontrol.repository;

import com.medcontrol.medcontrol.model.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Long> {

}