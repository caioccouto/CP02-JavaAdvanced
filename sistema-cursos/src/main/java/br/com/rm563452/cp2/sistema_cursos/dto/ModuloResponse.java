package br.com.rm563452.cp2.sistema_cursos.dto;

public record ModuloResponse(Long id, Long cursoId, String titulo, Integer ordem, Integer cargaHoraria) {
}
