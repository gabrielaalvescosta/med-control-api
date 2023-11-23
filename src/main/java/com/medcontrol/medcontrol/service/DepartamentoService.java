package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.model.DepartamentoModel;
import com.medcontrol.medcontrol.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<DepartamentoModel> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoModel> getDepartamentoById(Long id) {
        return departamentoRepository.findById(id);
    }

    public DepartamentoModel saveDepartamento(DepartamentoModel departamento) {
        // Lógica de validação e processamento, se necessário
        return departamentoRepository.save(departamento);
    }

    public void deleteDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }
}