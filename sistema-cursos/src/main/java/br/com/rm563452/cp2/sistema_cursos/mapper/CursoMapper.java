package br.com.rm563452.cp2.sistema_cursos.mapper;

import br.com.rm563452.cp2.sistema_cursos.dto.CursoResponse;
import br.com.rm563452.cp2.sistema_cursos.model.Curso;

public class CursoMapper {

    private CursoMapper(){}

    public static CursoResponse toResponse(Curso curso){
        return new CursoResponse(curso.getId(), curso.getTitulo(), getDescricao());
    }

}
