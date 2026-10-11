package br.com.rm563452.cp2.sistema_cursos.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " com id "+id+" não encontrado");
    }
}
