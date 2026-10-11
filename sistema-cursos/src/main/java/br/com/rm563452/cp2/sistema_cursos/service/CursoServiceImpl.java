package br.com.rm563452.cp2.sistema_cursos.service;

import br.com.rm563452.cp2.sistema_cursos.exceptions.ResourceNotFoundException;
import br.com.rm563452.cp2.sistema_cursos.model.Curso;
import br.com.rm563452.cp2.sistema_cursos.repository.CursoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class CursoServiceImpl implements CursoService{

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    public Page<Curso> findAll(Integer page, Integer size) {
        return this.cursoRepository.findAll(
                Pageable.ofSize(size).withPage(page)
        );
    }

    public Curso findById(Long id) {
        Optional<Curso> byId = this.cursoRepository.findById(id);
        if (byId.isEmpty()){
            throw new ResourceNotFoundException("curso",id);
        }
        return byId.get();
    }

    @Override
    public Curso findByIdWithModulo(Long id) {
        return this.cursoRepository.findWithModuloById(id)
                .orElseThrow(() -> new ResourceNotFoundException("curso", id));
    }

    public Curso create(Curso curso) {
        curso.setId(null);
        return this.cursoRepository.save(curso);
    }

    public Optional<Curso> update(Long id, Curso updated) {
        return this.cursoRepository.findById(id).map(existing -> {
            updated.setId(id);
            return cursoRepository.save(updated);
        });
    }

    public void delete(Long id) {
        Curso curso = findById(id);
        this.cursoRepository.delete(curso);
    }
}
