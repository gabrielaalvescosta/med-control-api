package com.medcontrol.medcontrol.controller;

import com.medcontrol.medcontrol.model.UnidadeDeTrabalhoModel;
import com.medcontrol.model.UnidadeDeTrabalhoModel;
import com.medcontrol.service.UnidadeDeTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/unidades-de-trabalho")
public class UnidadeDeTrabalhoController {

    private final UnidadeDeTrabalhoService unidadeDeTrabalhoService;

    @Autowired
    public UnidadeDeTrabalhoController(UnidadeDeTrabalhoService unidadeDeTrabalhoService) {
        this.unidadeDeTrabalhoService = unidadeDeTrabalhoService;
    }

    @GetMapping
    public ResponseEntity<Page<UnidadeDeTrabalhoModel>> getAllUnidadesDeTrabalho(Pageable pageable) {
        Page<UnidadeDeTrabalhoModel> unidadesDeTrabalho = unidadeDeTrabalhoService.getAllUnidadesDeTrabalho(pageable);
        return ResponseEntity.ok(unidadesDeTrabalho);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeDeTrabalhoModel> getUnidadeDeTrabalhoById(@PathVariable Long id) {
        UnidadeDeTrabalhoModel unidadeDeTrabalho = unidadeDeTrabalhoService.getUnidadeDeTrabalhoById(id);
        return ResponseEntity.ok(unidadeDeTrabalho);
    }

    @PostMapping
    public ResponseEntity<UnidadeDeTrabalhoModel> createUnidadeDeTrabalho(@Validated @RequestBody UnidadeDeTrabalhoModel unidadeDeTrabalhoModel) {
        UnidadeDeTrabalhoModel createdUnidadeDeTrabalho = unidadeDeTrabalhoService.createUnidadeDeTrabalho(unidadeDeTrabalhoModel);
        return ResponseEntity.ok(createdUnidadeDeTrabalho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeDeTrabalhoModel> updateUnidadeDeTrabalho(@PathVariable Long id, @Validated @RequestBody UnidadeDeTrabalhoModel unidadeDeTrabalhoModel) {
        UnidadeDeTrabalhoModel updatedUnidadeDeTrabalho = unidadeDeTrabalhoService.updateUnidadeDeTrabalho(id, unidadeDeTrabalhoModel);
        return ResponseEntity.ok(updatedUnidadeDeTrabalho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidadeDeTrabalho(@PathVariable Long id) {
        unidadeDeTrabalhoService.deleteUnidadeDeTrabalho(id);
        return ResponseEntity.noContent().build();
    }
}
