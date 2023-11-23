package com.medcontrol.medcontrol.controller;

import com.medcontrol.medcontrol.model.MedicamentoModel;
import com.medcontrol.model.MedicamentoModel;
import com.medcontrol.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public ResponseEntity<Page<MedicamentoModel>> getAllMedicamentos(Pageable pageable) {
        Page<MedicamentoModel> medicamentos = medicamentoService.getAllMedicamentos(pageable);
        return ResponseEntity.ok(medicamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoModel> getMedicamentoById(@PathVariable Long id) {
        MedicamentoModel medicamento = medicamentoService.getMedicamentoById(id);
        return ResponseEntity.ok(medicamento);
    }

    @PostMapping
    public ResponseEntity<MedicamentoModel> createMedicamento(@Validated @RequestBody MedicamentoModel medicamentoModel) {
        MedicamentoModel createdMedicamento = medicamentoService.createMedicamento(medicamentoModel);
        return ResponseEntity.ok(createdMedicamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoModel> updateMedicamento(@PathVariable Long id, @Validated @RequestBody MedicamentoModel medicamentoModel) {
        MedicamentoModel updatedMedicamento = medicamentoService.updateMedicamento(id, medicamentoModel);
        return ResponseEntity.ok(updatedMedicamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Long id) {
        medicamentoService.deleteMedicamento(id);
        return ResponseEntity.noContent().build();
    }
}
