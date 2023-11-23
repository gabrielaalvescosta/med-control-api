package com.medcontrol.medcontrol.controller;

import com.medcontrol.medcontrol.model.EstoqueModel;
import com.medcontrol.model.EstoqueModel;
import com.medcontrol.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estoques")
public class EstoqueController {

    private final EstoqueService estoqueService;

    @Autowired
    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping
    public ResponseEntity<Page<EstoqueModel>> getAllEstoques(Pageable pageable) {
        Page<EstoqueModel> estoques = estoqueService.getAllEstoques(pageable);
        return ResponseEntity.ok(estoques);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueModel> getEstoqueById(@PathVariable Long id) {
        EstoqueModel estoque = estoqueService.getEstoqueById(id);
        return ResponseEntity.ok(estoque);
    }

    @PostMapping
    public ResponseEntity<EstoqueModel> createEstoque(@Validated @RequestBody EstoqueModel estoqueModel) {
        EstoqueModel createdEstoque = estoqueService.createEstoque(estoqueModel);
        return ResponseEntity.ok(createdEstoque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstoqueModel> updateEstoque(@PathVariable Long id, @Validated @RequestBody EstoqueModel estoqueModel) {
        EstoqueModel updatedEstoque = estoqueService.updateEstoque(id, estoqueModel);
        return ResponseEntity.ok(updatedEstoque);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstoque(@PathVariable Long id) {
        estoqueService.deleteEstoque(id);
        return ResponseEntity.noContent().build();
    }
}
