package ar.codigomariano.service;

import org.springframework.stereotype.Service;

import ar.codigomariano.ejemplo1.domain.Alumno;
import ar.codigomariano.repository.AlumnoRepository;

import java.util.List;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public Alumno guardar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
    
    public List<Alumno> listarTodos() {
        return alumnoRepository.findAll();
    }
}
