package com.medcontrol.medcontrol.controller;

import com.medcontrol.medcontrol.model.UnidadeTrabalhoModel;
import com.medcontrol.medcontrol.service.UnidadeTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidades-de-trabalho")
public class UnidadeTrabalhoController {

    private final UnidadeTrabalhoService unidadeDeTrabalhoService;

    @Autowired
    public UnidadeTrabalhoController(UnidadeTrabalhoService unidadeDeTrabalhoService) {
        this.unidadeDeTrabalhoService = unidadeDeTrabalhoService;
    }

    @GetMapping
    public ResponseEntity<List<UnidadeTrabalhoModel>> getAllUnidadesDeTrabalho() {
        List<UnidadeTrabalhoModel> unidadesDeTrabalho = unidadeDeTrabalhoService.getAllUnidadesTrabalho();
        return ResponseEntity.ok(unidadesDeTrabalho);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeTrabalhoModel> getUnidadeDeTrabalhoById(@PathVariable Long id) {
        UnidadeTrabalhoModel unidadeDeTrabalho = unidadeDeTrabalhoService.getUnidadeTrabalhoById(id);
        return ResponseEntity.ok(unidadeDeTrabalho);
    }

    @PostMapping
    public ResponseEntity<UnidadeTrabalhoModel> createUnidadeDeTrabalho(@Validated @RequestBody UnidadeTrabalhoModel unidadeTrabalhoModel) {
        UnidadeTrabalhoModel createdUnidadeDeTrabalho = unidadeDeTrabalhoService.createUnidadeTrabalho(unidadeTrabalhoModel);
        return ResponseEntity.ok(createdUnidadeDeTrabalho);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidadeDeTrabalho(@PathVariable Long id) {
        unidadeDeTrabalhoService.deleteUnidadeTrabalho(id);
        return ResponseEntity.noContent().build();
    }
}
