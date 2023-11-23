package com.medcontrol.medcontrol.controller;

import com.medcontrol.medcontrol.model.DepartamentoModel;
import com.medcontrol.model.DepartamentoModel;
import com.medcontrol.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public ResponseEntity<Page<DepartamentoModel>> getAllDepartamentos(Pageable pageable) {
        Page<DepartamentoModel> departamentos = departamentoService.getAllDepartamentos(pageable);
        return ResponseEntity.ok(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoModel> getDepartamentoById(@PathVariable Long id) {
        DepartamentoModel departamento = departamentoService.getDepartamentoById(id);
        return ResponseEntity.ok(departamento);
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> createDepartamento(@Validated @RequestBody DepartamentoModel departamentoModel) {
        DepartamentoModel createdDepartamento = departamentoService.createDepartamento(departamentoModel);
        return ResponseEntity.ok(createdDepartamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoModel> updateDepartamento(@PathVariable Long id, @Validated @RequestBody DepartamentoModel departamentoModel) {
        DepartamentoModel updatedDepartamento = departamentoService.updateDepartamento(id, departamentoModel);
        return ResponseEntity.ok(updatedDepartamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable Long id) {
        departamentoService.deleteDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}
