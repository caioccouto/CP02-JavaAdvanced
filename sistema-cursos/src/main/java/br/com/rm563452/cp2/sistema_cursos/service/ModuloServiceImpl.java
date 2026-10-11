package br.com.rm563452.cp2.sistema_cursos.service;

import br.com.rm563452.cp2.sistema_cursos.exceptions.ResourceNotFoundException;
import br.com.rm563452.cp2.sistema_cursos.model.Curso;
import br.com.rm563452.cp2.sistema_cursos.model.Modulo;
import br.com.rm563452.cp2.sistema_cursos.repository.ModuloRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
class ModuloServiceImpl implements ModuloService{

    private final ModuloRepository moduloRepository;

    public ModuloServiceImpl(ModuloRepository moduloRepository){
        this.moduloRepository = moduloRepository;
    }

    @Override
    public Page<Modulo> findAll(Integer page, Integer size) {
        return this.moduloRepository.findAll(
                Pageable.ofSize(size).withPage(page)
        );
    }

    @Override
    public Page<Modulo> findByCursoId(Long cursoId, Integer page, Integer size) {
        return moduloRepository.findByCursoId(
                cursoId,
                Pageable.ofSize(size).withPage(page)
        );
    }

    @Override
    public Modulo findById(Long id) {
        return moduloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Milestone", id));
    }

    @Override
    public Modulo create(Modulo modulo) {
        modulo.setId(null);
        return this.moduloRepository.save(modulo);
    }

    @Override
    public Modulo update(Long id, Modulo updated) {
        updated.setId(id);
        return moduloRepository.save(updated);
    }

    @Override
    public void delete(Long id) {
        Modulo modulo = findById(id);
        this.moduloRepository.delete(modulo);
    }
}
