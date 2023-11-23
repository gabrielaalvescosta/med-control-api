package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.model.UnidadeTrabalhoModel;
import com.medcontrol.medcontrol.repository.UnidadeTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeTrabalhoService {
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    @Autowired
    public UnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    public List<UnidadeTrabalhoModel> getAllUnidadesTrabalho() {
        return unidadeTrabalhoRepository.findAll();
    }

    public Optional<UnidadeTrabalhoModel> getUnidadeTrabalhoById(Long id) {
        return unidadeTrabalhoRepository.findById(id);
    }

    public UnidadeTrabalhoModel saveUnidadeTrabalho(UnidadeTrabalhoModel unidadeTrabalho) {
        // Lógica de validação e processamento, se necessário
        return unidadeTrabalhoRepository.save(unidadeTrabalho);
    }

    public void deleteUnidadeTrabalho(Long id) {
        unidadeTrabalhoRepository.deleteById(id);
    }
}
