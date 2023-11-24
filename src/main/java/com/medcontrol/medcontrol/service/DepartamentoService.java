package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.exception.DepartamentoNotFoundException;
import com.medcontrol.medcontrol.model.DepartamentoModel;
import com.medcontrol.medcontrol.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<DepartamentoModel> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    public DepartamentoModel getDepartamentoById(Long id) {
        Optional<DepartamentoModel> optionalDepartamento = departamentoRepository.findById(id);
        return optionalDepartamento.orElseThrow(() -> new DepartamentoNotFoundException("Departamento não encontrado com o ID: " + id));
    }

    public DepartamentoModel createDepartamento(DepartamentoModel departamento) {
        return departamentoRepository.save(departamento);
    }

    public DepartamentoModel updateDepartamento(Long id, DepartamentoModel departamento) {
        if (departamentoRepository.existsById(id)) {
            departamento.setId(id);
            return departamentoRepository.save(departamento);
        } else {
            throw new DepartamentoNotFoundException("Departamento não encontrado com o ID: " + id);
        }
    }

    public void deleteDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }
}