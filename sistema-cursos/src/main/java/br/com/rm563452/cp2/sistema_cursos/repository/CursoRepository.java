package br.com.rm563452.cp2.sistema_cursos.repository;

import br.com.rm563452.cp2.sistema_cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
