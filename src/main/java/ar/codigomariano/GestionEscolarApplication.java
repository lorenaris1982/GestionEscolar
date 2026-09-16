package ar.codigomariano;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ar.codigomariano.ejemplo1.domain.Alumno;
import ar.codigomariano.service.AlumnoService;

@SpringBootApplication
public class GestionEscolarApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionEscolarApplication.class, args);
    }

    @Bean
    CommandLineRunner ejecutar(AlumnoService alumnoService) {
        return args -> {

            Alumno alumno = new Alumno(
                    "Ana",
                    "Perez",
                    "34567898",
                    "34567898",
                    "5",
                    "A",
                    "Mañana"
            );

            alumno.completarDatos(  
                    "31/05/2010", 
                    "ana@email.com",
                    "11223348"
            );

            Alumno guardado = alumnoService.guardar(alumno);

            System.out.println("=== ALUMNO GUARDADO ===");
            System.out.println("ID: " + guardado.getId());
            System.out.println("Nombre: " + guardado.getNombre());
            System.out.println("Apellido: " + guardado.getApellido());
            System.out.println("DNI: " + guardado.getDni());
            
            System.out.println();

            System.out.println("=== ALUMNOS EN LA BASE DE DATOS ===");

            alumnoService.listarTodos().forEach(a -> {
                System.out.println(
                    a.getId() + " - " +
                    a.getNombre() + " " +
                    a.getApellido() +
                    " - DNI: " + a.getDni()
                );
            });
        };
        
        
    }
}