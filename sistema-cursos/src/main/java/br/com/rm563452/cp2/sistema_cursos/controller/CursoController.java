package br.com.rm563452.cp2.sistema_cursos.controller;

import br.com.rm563452.cp2.sistema_cursos.dto.*;
import br.com.rm563452.cp2.sistema_cursos.mapper.CursoMapper;
import br.com.rm563452.cp2.sistema_cursos.mapper.ModuloMapper;
import br.com.rm563452.cp2.sistema_cursos.model.Curso;
import br.com.rm563452.cp2.sistema_cursos.model.Modulo;
import br.com.rm563452.cp2.sistema_cursos.service.CursoService;
import br.com.rm563452.cp2.sistema_cursos.service.ModuloService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/cursos")
@Validated
public class CursoController {

    private final CursoService cursoService;
    private final ModuloService moduloService;

    public CursoController(CursoService cursoService, ModuloService moduloService){
        this.cursoService = cursoService;
        this.moduloService = moduloService;
    }

    @PostMapping
    public ResponseEntity<CursoResponse> createCurso(@RequestBody @Valid CursoRequest request){
        Curso curso = new Curso();
        curso.setTitulo(request.titulo());
        curso.setDescricao(request.descricao());

        Curso salvo = cursoService.create(curso);
        return ResponseEntity.created(URI.create("/api/cursos/" + salvo.getId())).body(CursoMapper.toResponse(salvo));
    }

    @GetMapping
    public PageResponse<CursoResponse> getAllCursos(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                    @RequestParam(required = false, defaultValue = "10") Integer sizePage)
    {
        Page<Curso> pageResult = this.cursoService.findAll(page, sizePage);

        return PageResponse.from(pageResult.map(CursoMapper::toResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> findById(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(CursoMapper.toResponse(cursoService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> updateCurso(@PathVariable Long id, @RequestBody CursoRequest request) {
        Curso curso =cursoService.findById(id);
        curso.setTitulo(request.titulo());
        curso.setDescricao(request.descricao());

        Curso updated = cursoService.update(id, curso).orElseThrow();
        return ResponseEntity.ok(CursoMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        this.cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cursoId}/modulos")
    public ResponseEntity<PageResponse<ModuloResponse>> getModulosByCurso(@PathVariable @Positive Long cursoId,
                                                                          @RequestParam(defaultValue = "0") Integer page,
                                                                          @RequestParam(defaultValue = "10") Integer sizePage)
    {
        cursoService.findById(cursoId);

        Page<Modulo> pageResult =
                moduloService.findByCursoId(cursoId, page, sizePage);

        return ResponseEntity.ok(PageResponse.from(pageResult.map(ModuloMapper::toResponse)));
    }

    @PostMapping("/{cursoId}/modulos")
    public ResponseEntity<ModuloResponse> createModulo(@PathVariable @Positive Long cursoId, @RequestBody @Valid ModuloRequest request) {

        Curso curso = cursoService.findById(cursoId);

        Modulo modulo = new Modulo();
        modulo.setTitulo(request.titulo());
        modulo.setOrdem(request.ordem());
        modulo.setCargaHoraria(request.cargaHoraria());
        modulo.setCurso(curso);

        Modulo salvo = moduloService.create(modulo);

        return ResponseEntity.created(URI.create("/api/modulos/" + salvo.getId())).body(ModuloMapper.toResponse(salvo));
    }
}
