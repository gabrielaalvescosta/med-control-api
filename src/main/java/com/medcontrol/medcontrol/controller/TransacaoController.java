package com.medcontrol.medcontrol.controller;

import com.medcontrol.medcontrol.model.TransacaoModel;
import com.medcontrol.medcontrol.service.TransacaoService;
import com.medcontrol.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<Page<TransacaoModel>> getAllTransacoes(Pageable pageable) {
        Page<TransacaoModel> transacoes = transacaoService.getAllTransacoes(pageable);
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoModel> getTransacaoById(@PathVariable Long id) {
        TransacaoModel transacao = transacaoService.getTransacaoById(id);
        return ResponseEntity.ok(transacao);
    }

    @PostMapping
    public ResponseEntity<TransacaoModel> createTransacao(@Validated @RequestBody TransacaoModel transacaoModel) {
        TransacaoModel createdTransacao = transacaoService.createTransacao(transacaoModel);
        return ResponseEntity.ok(createdTransacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransacaoModel> updateTransacao(@PathVariable Long id, @Validated @RequestBody TransacaoModel transacaoModel) {
        TransacaoModel updatedTransacao = transacaoService.updateTransacao(id, transacaoModel);
        return ResponseEntity.ok(updatedTransacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransacao(@PathVariable Long id) {
        transacaoService.deleteTransacao(id);
        return ResponseEntity.noContent().build();
    }
}
