package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.model.EstoqueModel;
import com.medcontrol.medcontrol.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    private final EstoqueRepository estoqueRepository;

    @Autowired
    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public List<EstoqueModel> getAllEstoques() {
        return estoqueRepository.findAll();
    }

    public Optional<EstoqueModel> getEstoqueById(Long id) {
        return estoqueRepository.findById(id);
    }

    public EstoqueModel saveEstoque(EstoqueModel estoque) {
        // Lógica de validação e processamento, se necessário
        return estoqueRepository.save(estoque);
    }

    public void deleteEstoque(Long id) {
        estoqueRepository.deleteById(id);
    }
}