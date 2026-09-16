package ar.codigomariano.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.codigomariano.repository.AlumnoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import ar.codigomariano.ejemplo1.domain.Alumno;
import ar.codigomariano.repository.AlumnoRepository;

@SpringBootTest
@Transactional
public class AlumnoServiceIntegracionTest {

    @Autowired
    AlumnoService alumnoService;

    @Autowired
    AlumnoRepository alumnoRepository;
    
    @Test
    void debeGuardarYRecuperarAlumnoDesdeLaBaseDeDatos() {

        Alumno alumno = new Alumno(
                "Laura",
                "Gomez",
                "98765432",
                "98765432",
                "5",
                "A",
                "Mañana"
        );

        alumno.completarDatos(
                "20/08/2010",
                "laura@email.com",
                "1122334455"
        );

        Alumno guardado = alumnoService.guardar(alumno);

        assertNotNull(guardado.getId());

        Alumno encontrado = alumnoRepository
                .findById(guardado.getId())
                .orElseThrow();

        assertEquals("Laura", encontrado.getNombre());
        assertEquals("98765432", encontrado.getDni());
    }

}
