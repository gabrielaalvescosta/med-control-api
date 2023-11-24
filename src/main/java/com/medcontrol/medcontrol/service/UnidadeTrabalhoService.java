package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.exception.UnidadeTrabalhoNotFoundException;
import com.medcontrol.medcontrol.model.FuncionarioModel;
import com.medcontrol.medcontrol.model.UnidadeTrabalhoModel;
import com.medcontrol.medcontrol.repository.UnidadeTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public UnidadeTrabalhoModel getUnidadeTrabalhoById(Long id) {
        return unidadeTrabalhoRepository.findById(id).orElse(null);
    }

    public UnidadeTrabalhoModel createUnidadeTrabalho(UnidadeTrabalhoModel unidadeTrabalho) {
        adicionarFuncionarios(unidadeTrabalho.getId(), unidadeTrabalho.getFuncionarios());
        return unidadeTrabalhoRepository.save(unidadeTrabalho);
    }

    public void deleteUnidadeTrabalho(Long id) {
        unidadeTrabalhoRepository.deleteById(id);
    }


    public UnidadeTrabalhoModel adicionarFuncionarios(Long idUnidade, List<FuncionarioModel> funcionarios) {
        UnidadeTrabalhoModel unidade = unidadeTrabalhoRepository.findById(idUnidade).orElse(null);

        if (unidade != null) {
            List<FuncionarioModel> funcionariosAtuais = unidade.getFuncionarios();
            funcionariosAtuais.addAll(funcionarios);
            unidade.setFuncionarios(funcionariosAtuais);
            return unidadeTrabalhoRepository.save(unidade);
        } else {
            throw new UnidadeTrabalhoNotFoundException("A unidade informada não existe");
        }

    }
}
