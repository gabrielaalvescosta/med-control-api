package com.medcontrol.medcontrol.controller;

import com.medcontrol.medcontrol.model.DepartamentoModel;
import com.medcontrol.medcontrol.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> getAllDepartamentos() {
        List<DepartamentoModel> departamentos = departamentoService.getAllDepartamentos();
        return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoModel> getDepartamentoById(@PathVariable Long id) {
        DepartamentoModel departamento = departamentoService.getDepartamentoById(id);
        if (departamento != null) {
            return new ResponseEntity<>(departamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> createDepartamento(@RequestBody DepartamentoModel departamento) {
        DepartamentoModel createdDepartamento = departamentoService.createDepartamento(departamento);
        return new ResponseEntity<>(createdDepartamento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoModel> updateDepartamento(
            @PathVariable Long id,
            @RequestBody DepartamentoModel departamento) {
        DepartamentoModel updatedDepartamento = departamentoService.updateDepartamento(id, departamento);

        if (updatedDepartamento != null) {
            return new ResponseEntity<>(updatedDepartamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable Long id) {
        departamentoService.deleteDepartamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}