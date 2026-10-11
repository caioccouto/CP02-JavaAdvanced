package br.com.rm563452.cp2.sistema_cursos.service;

import br.com.rm563452.cp2.sistema_cursos.model.Curso;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> findAll();

    Page<Curso> findAll(Integer page, Integer size);

    Curso findById(Long id);

    Curso findByIdWithModulo(Long id);

    Curso create(Curso curso);

    Optional<Curso> update(Long id, Curso curso);

    void delete(Long id);
}
