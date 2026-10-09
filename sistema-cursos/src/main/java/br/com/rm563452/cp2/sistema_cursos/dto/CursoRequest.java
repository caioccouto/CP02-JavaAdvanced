package br.com.rm563452.cp2.sistema_cursos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CursoRequest(

        Long id,

        @NotBlank(message = "título não pode ser vazio")
        @Size(max = 150, message = "título deve conter no máximo 150 caracteres")
        String titulo,

        @NotBlank(message = "descrição não pode estar vazia")
        String descricao) {
}
