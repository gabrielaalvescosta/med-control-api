package com.medcontrol.medcontrol.controller;

import com.medcontrol.medcontrol.model.UnidadeTrabalhoModel;
import com.medcontrol.medcontrol.service.UnidadeTrabalhoService;
import com.medcontrol.service.UnidadeDeTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/unidades-de-trabalho")
public class UnidadeTrabalhoController {

    private final UnidadeTrabalhoService unidadeDeTrabalhoService;

    @Autowired
    public UnidadeTrabalhoController(UnidadeTrabalhoService unidadeDeTrabalhoService) {
        this.unidadeDeTrabalhoService = unidadeDeTrabalhoService;
    }

    @GetMapping
    public ResponseEntity<Page<UnidadeTrabalhoModel>> getAllUnidadesDeTrabalho(Pageable pageable) {
        Page<UnidadeTrabalhoModel> unidadesDeTrabalho = unidadeDeTrabalhoService.getAllUnidadesDeTrabalho(pageable);
        return ResponseEntity.ok(unidadesDeTrabalho);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeTrabalhoModel> getUnidadeDeTrabalhoById(@PathVariable Long id) {
        UnidadeTrabalhoModel unidadeDeTrabalho = unidadeDeTrabalhoService.getUnidadeDeTrabalhoById(id);
        return ResponseEntity.ok(unidadeDeTrabalho);
    }

    @PostMapping
    public ResponseEntity<UnidadeTrabalhoModel> createUnidadeDeTrabalho(@Validated @RequestBody UnidadeTrabalhoModel unidadeTrabalhoModel) {
        UnidadeTrabalhoModel createdUnidadeDeTrabalho = unidadeDeTrabalhoService.createUnidadeDeTrabalho(unidadeTrabalhoModel);
        return ResponseEntity.ok(createdUnidadeDeTrabalho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeTrabalhoModel> updateUnidadeDeTrabalho(@PathVariable Long id, @Validated @RequestBody UnidadeTrabalhoModel unidadeTrabalhoModel) {
        UnidadeTrabalhoModel updatedUnidadeDeTrabalho = unidadeDeTrabalhoService.updateUnidadeDeTrabalho(id, unidadeTrabalhoModel);
        return ResponseEntity.ok(updatedUnidadeDeTrabalho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidadeDeTrabalho(@PathVariable Long id) {
        unidadeDeTrabalhoService.deleteUnidadeDeTrabalho(id);
        return ResponseEntity.noContent().build();
    }
}
