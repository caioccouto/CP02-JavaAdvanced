package br.com.rm563452.cp2.sistema_cursos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ModuloRequest(

        Long id,

        @NotBlank(message = "título não pode ser vazio")
        @Size(max = 150, message = "título deve conter no máximo 150 caracteres")
        String titulo,

        @NotNull(message = "ordem é obrigatória")
        @Positive(message = "ordem deve ser positiva")
        Integer ordem,

        @NotNull(message = "carga horária é obrigatória")
        @Positive(message = "carga horária deve ser positiva")
        Integer cargaHoraria) {
}
