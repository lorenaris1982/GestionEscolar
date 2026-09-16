package ar.codigomariano.service;

import org.springframework.stereotype.Service;


import ar.codigomariano.ejemplo1.domain.Alumno;
import ar.codigomariano.repository.AlumnoRepository;

import java.util.List;

import ar.codigomariano.exception.AlumnoInvalidoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public Alumno guardar(Alumno alumno) {
    	
    	if (alumno == null) {
    	    throw new AlumnoInvalidoException("El alumno no puede ser null");
    	}
    	
    	if (alumno.getDni() == null || alumno.getDni().isBlank()) {
        throw new AlumnoInvalidoException("El DNI del alumno es obligatorio");
        
    }
    	
    	if (!alumno.getDni().matches("\\d{8}")) {
        throw new AlumnoInvalidoException("El DNI debe tener exactamente 8 números, sin puntos");
    }
    	
    	
    	if (alumno.getNombre() == null || alumno.getNombre().isBlank()) {
    	    throw new AlumnoInvalidoException("El nombre del alumno es obligatorio");
    	}
    	
    	if (alumno.getApellido() == null || alumno.getApellido().isBlank()) {
    	    throw new AlumnoInvalidoException("El apellido del alumno es obligatorio");
    	}
    	
    	if (alumno.getNumeroLegajo() == null || alumno.getNumeroLegajo().isBlank()) {
    	    throw new AlumnoInvalidoException("El número de legajo es obligatorio");
    	}
    	
    	if (!alumno.getDni().equals(alumno.getNumeroLegajo())) {
    	    throw new AlumnoInvalidoException(
    	        "El DNI y el número de legajo deben coincidir");
    	}
    	
    	if (alumno.getCurso() == null || alumno.getCurso().isBlank()) {
    	    throw new AlumnoInvalidoException("El curso es obligatorio");
    	}
    	
    	
    	try {
    	    int curso = Integer.parseInt(alumno.getCurso());

    	    if (curso < 1 || curso > 7) {
    	        throw new AlumnoInvalidoException("El curso debe estar entre 1 y 7");
    	    }

    	} catch (NumberFormatException e) {
    	    throw new AlumnoInvalidoException("El curso debe ser un número entre 1 y 7");
    	}
    	
    	if (alumno.getDivision() == null || alumno.getDivision().isBlank()) {
    	    throw new AlumnoInvalidoException("La división es obligatoria");
    	}
    	
    	if (!alumno.getDivision().matches("[A-Z]")) {
    	    throw new AlumnoInvalidoException(
    	        "La división debe ser una sola letra mayúscula"
    	    );
    	}
    	
    	if (alumno.getTurno() == null || alumno.getTurno().isBlank()) {
    	    throw new AlumnoInvalidoException("El turno es obligatorio");
    	}
    	
    	if (!alumno.getTurno().equals("Mañana")
    	        && !alumno.getTurno().equals("Tarde")
    	        && !alumno.getTurno().equals("Noche")) {

    	    throw new AlumnoInvalidoException(
    	        "El turno debe ser Mañana, Tarde o Noche"
    	    );
    	}
    	
    	if (alumno.getMail() == null || alumno.getMail().isBlank()) {
    	    throw new AlumnoInvalidoException("El mail es obligatorio");
    	}
    	
    	if (!alumno.getMail().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
    	    throw new AlumnoInvalidoException(
    	        "El mail no tiene un formato válido");
    	}
    	
    	if (!alumno.getMail().equals(alumno.getMail().toLowerCase())) {
    	    throw new AlumnoInvalidoException(
    	        "El mail debe estar escrito completamente en minúsculas"
    	    );
    	}
     	    	
    	if (alumno.getFechaNacimiento() == null || alumno.getFechaNacimiento().isBlank()) {
    	    throw new AlumnoInvalidoException("La fecha de nacimiento es obligatoria");
    	}
    	
    	if (!alumno.getFechaNacimiento().matches("\\d{2}/\\d{2}/\\d{4}")) {
    	    throw new AlumnoInvalidoException(
    	        "La fecha de nacimiento debe tener el formato DD/MM/AAAA"
    	    );
    	}
    	
    	try {
    	    DateTimeFormatter formato = DateTimeFormatter
    	            .ofPattern("dd/MM/uuuu")
    	            .withResolverStyle(java.time.format.ResolverStyle.STRICT);

    	    LocalDate fechaNacimiento = LocalDate.parse(
    	            alumno.getFechaNacimiento(), formato);

    	    if (fechaNacimiento.isAfter(LocalDate.now())) {
    	        throw new AlumnoInvalidoException(
    	            "La fecha de nacimiento no puede ser futura"
    	        );
    	    }

    	} catch (DateTimeParseException e) {
    	    throw new AlumnoInvalidoException(
    	        "La fecha de nacimiento no es válida"
    	    );
    	}
    	
    	
    	if (alumno.getTelefono() == null || alumno.getTelefono().isBlank()) {
    	    throw new AlumnoInvalidoException("El teléfono es obligatorio");
    	}
    	
    	if (!alumno.getTelefono().matches("\\d{8,15}")) {
    	    throw new AlumnoInvalidoException(
    	        "El teléfono debe contener entre 8 y 15 números");
    	}
    	
    	
    	
        return alumnoRepository.save(alumno);
    }
    
    public List<Alumno> listarTodos() {
        return alumnoRepository.findAll();
    }
    
    
}
