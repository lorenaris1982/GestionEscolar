package ar.codigomariano.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.codigomariano.ejemplo1.domain.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    Optional<Alumno> findByDniAndContrasena(String dni, String contrasena);
}
