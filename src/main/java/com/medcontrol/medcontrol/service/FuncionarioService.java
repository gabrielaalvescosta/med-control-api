package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.exception.FuncionarioNotFoundException;
import com.medcontrol.medcontrol.model.FuncionarioModel;
import com.medcontrol.medcontrol.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public FuncionarioModel getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionário não encontrado com o ID: " + id));
    }

    @Transactional
    public FuncionarioModel createFuncionario(FuncionarioModel funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Transactional
    public FuncionarioModel updateFuncionario(Long id, FuncionarioModel funcionario) {
        FuncionarioModel existingFuncionario = getFuncionarioById(id);
        existingFuncionario.setNome(funcionario.getNome());
        existingFuncionario.setDepartamento(funcionario.getDepartamento());
        // Atualize outras propriedades conforme necessário

        return funcionarioRepository.save(existingFuncionario);
    }

    @Transactional
    public void deleteFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}