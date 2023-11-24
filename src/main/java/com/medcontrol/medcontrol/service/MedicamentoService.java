package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.model.MedicamentoModel;
import com.medcontrol.medcontrol.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {
    private final MedicamentoRepository medicamentoRepository;

    @Autowired
    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public List<MedicamentoModel> getAllMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public MedicamentoModel getMedicamentoById(Long id) {
        return medicamentoRepository.findById(id).orElse(null);
    }

    public MedicamentoModel createMedicamento(MedicamentoModel medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public void deleteMedicamento(Long id) {
        medicamentoRepository.deleteById(id);
    }
}