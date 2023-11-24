package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.exception.MedicamentoNotFoundException;
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
        return medicamentoRepository.findById(id)
                .orElseThrow(() -> new MedicamentoNotFoundException("Medicamento não encontrado com o ID: " + id));
    }

    public MedicamentoModel createMedicamento(MedicamentoModel medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public void deleteMedicamento(Long id) {
        if (!medicamentoRepository.existsById(id)) {
            throw new MedicamentoNotFoundException("O id para este nmedicamento não existe ou já foi excluído");
        } else {
            medicamentoRepository.deleteById(id);
        }

    }
}
