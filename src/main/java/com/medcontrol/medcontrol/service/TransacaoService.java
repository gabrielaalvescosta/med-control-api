package com.medcontrol.medcontrol.service;

import com.medcontrol.medcontrol.model.TransacaoModel;
import com.medcontrol.medcontrol.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public TransacaoModel getTransacaoById(Long id) {
        return transacaoRepository.findById(id).orElse(null);
    }

    public TransacaoModel createTransacao(TransacaoModel transacao) {
        return transacaoRepository.save(transacao);
    }

    public void deleteTransacao(Long id) {
        transacaoRepository.deleteById(id);
    }
}