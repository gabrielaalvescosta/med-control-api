package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.model.FuncionarioModel;
import com.medcontrol.medcontrol.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<FuncionarioModel> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<FuncionarioModel> getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public FuncionarioModel saveFuncionario(FuncionarioModel funcionario) {
        // Lógica de validação e processamento, se necessário
        return funcionarioRepository.save(funcionario);
    }

    public void deleteFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}