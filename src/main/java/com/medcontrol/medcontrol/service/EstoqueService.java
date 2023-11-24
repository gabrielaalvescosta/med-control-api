package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.exception.EstoqueNotFoundException;
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

    public EstoqueModel getEstoqueById(Long id) {
        return estoqueRepository.findById(id).orElse(null);
    }

    public EstoqueModel saveEstoque(EstoqueModel estoque) {
        return estoqueRepository.save(estoque);
    }

    public void deleteEstoque(Long id) {
        estoqueRepository.deleteById(id);
    }


    public EstoqueModel updateEstoque(Long id, EstoqueModel estoqueAtualizado) {
        Optional<EstoqueModel> optionalEstoque = estoqueRepository.findById(id);

        if (optionalEstoque.isPresent()) {
            EstoqueModel estoqueExistente = optionalEstoque.get();

            estoqueExistente.setMedicamento(estoqueAtualizado.getMedicamento());
            estoqueExistente.setQuantidade(estoqueAtualizado.getQuantidade());

            return estoqueRepository.save(estoqueExistente);
        } else {
            new EstoqueNotFoundException("Não foi possivel encontrar o estoque");
            return null;
        }
    }
}