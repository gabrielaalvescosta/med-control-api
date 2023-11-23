package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.model.MedicamentoModel;
import com.medcontrol.medcontrol.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<MedicamentoModel> getMedicamentoById(Long id) {
        return medicamentoRepository.findById(id);
    }

    public MedicamentoModel saveMedicamento(MedicamentoModel medicamento) {
        // Lógica de validação e processamento, se necessário
        return medicamentoRepository.save(medicamento);
    }

    public void deleteMedicamento(Long id) {
        medicamentoRepository.deleteById(id);
    }
}