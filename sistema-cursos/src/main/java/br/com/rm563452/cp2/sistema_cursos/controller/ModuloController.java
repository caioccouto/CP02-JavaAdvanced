package br.com.rm563452.cp2.sistema_cursos.controller;
import br.com.rm563452.cp2.sistema_cursos.dto.ModuloResponse;
import br.com.rm563452.cp2.sistema_cursos.mapper.ModuloMapper;
import br.com.rm563452.cp2.sistema_cursos.service.ModuloService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modulos")
@Validated
public class ModuloController {

    private final ModuloService moduloService;

    public ModuloController(ModuloService moduloService){
        this.moduloService = moduloService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuloResponse> findById(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(ModuloMapper.toResponse(moduloService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModulo(@PathVariable Long id) {
        this.moduloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
