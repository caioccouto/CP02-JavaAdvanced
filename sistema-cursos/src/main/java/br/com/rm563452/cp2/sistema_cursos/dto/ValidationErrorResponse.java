package br.com.rm563452.cp2.sistema_cursos.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ValidationErrorResponse(LocalDateTime timestamp, int status, String error, List<ErrorFieldCustom> errors) {
}
