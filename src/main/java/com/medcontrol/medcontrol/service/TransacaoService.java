package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.model.TransacaoModel;
import com.medcontrol.medcontrol.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public List<TransacaoModel> getAllTransacoes() {
        return transacaoRepository.findAll();
    }

    public Optional<TransacaoModel> getTransacaoById(Long id) {
        return transacaoRepository.findById(id);
    }

    public TransacaoModel saveTransacao(TransacaoModel transacao) {
        // Lógica de validação e processamento, se necessário
        return transacaoRepository.save(transacao);
    }

    public void deleteTransacao(Long id) {
        transacaoRepository.deleteById(id);
    }
}