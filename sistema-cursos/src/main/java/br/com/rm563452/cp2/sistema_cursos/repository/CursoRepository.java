package br.com.rm563452.cp2.sistema_cursos.repository;

import br.com.rm563452.cp2.sistema_cursos.model.Curso;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    @EntityGraph(attributePaths = "modulos")
    Optional<Curso> findWithModuloById(Long id);
}
