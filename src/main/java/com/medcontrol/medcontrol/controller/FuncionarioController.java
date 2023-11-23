import com.medcontrol.medcontrol.model.FuncionarioModel;
import com.medcontrol.model.FuncionarioModel;
import com.medcontrol.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<Page<FuncionarioModel>> getAllFuncionarios(Pageable pageable) {
        Page<FuncionarioModel> funcionarios = funcionarioService.getAllFuncionarios(pageable);
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> getFuncionarioById(@PathVariable Long id) {
        FuncionarioModel funcionario = funcionarioService.getFuncionarioById(id);
        return ResponseEntity.ok(funcionario);
    }

    @PostMapping
    public ResponseEntity<FuncionarioModel> createFuncionario(@Validated @RequestBody FuncionarioModel funcionarioModel) {
        FuncionarioModel createdFuncionario = funcionarioService.createFuncionario(funcionarioModel);
        return ResponseEntity.ok(createdFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> updateFuncionario(@PathVariable Long id, @Validated @RequestBody FuncionarioModel funcionarioModel) {
        FuncionarioModel updatedFuncionario = funcionarioService.updateFuncionario(id, funcionarioModel);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        funcionarioService.deleteFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
