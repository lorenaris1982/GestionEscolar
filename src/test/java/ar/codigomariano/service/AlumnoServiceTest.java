package ar.codigomariano.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ar.codigomariano.ejemplo1.domain.Alumno;
import ar.codigomariano.exception.AlumnoInvalidoException;
import ar.codigomariano.repository.AlumnoRepository;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class AlumnoServiceTest {
	
	@Mock
	AlumnoRepository alumnoRepository;

	@InjectMocks
	AlumnoService alumnoService;
	
	@Test
	void debeRechazarDniConMenosDeOchoNumeros() {

	    Alumno alumno = new Alumno(
	    		   "Ana",
	               "Perez",
	               "1234567",
	               "1234567",
	               "5",
	               "A",
	               "Mañana"
	           	           
	    );
	

	    //AlumnoService alumnoService = null;

	    assertThrows(
	            AlumnoInvalidoException.class,
	            () -> alumnoService.guardar(alumno));
	};
	            
	            @Test
	    		void debeRechazarAlumnoSinDni() {

	    		    Alumno alumno = new Alumno(
	    		    		   "Ana",
	    		               "Perez",
	    		               "",
	    		               "",
	    		               "5",
	    		               "A",
	    		               "Mañana"
	    		           	           
	    		    );
	            

	    		    //AlumnoService alumnoService = null;

	    		    assertThrows(
	    		            AlumnoInvalidoException.class,
	    		            () -> alumnoService.guardar(alumno)
	    		    );
	   
	    
	    
	}

	            
	            @Test
	            void debeRechazarDniYLegajoDiferentes() {

	                Alumno alumno = new Alumno(
	                        "Ana",
	                        "Perez",
	                        "12345678",
	                        "87654321",
	                        "5",
	                        "A",
	                        "Mañana"
	                );

	                assertThrows(
	                        AlumnoInvalidoException.class,
	                        () -> alumnoService.guardar(alumno)
	                );
	            }
	            
	            @Test
	            void debeRechazarCursoFueraDeRango() {

	                Alumno alumno = new Alumno(
	                        "Ana",
	                        "Perez",
	                        "12345678",
	                        "12345678",
	                        "8",
	                        "A",
	                        "Mañana"
	                );

	                assertThrows(
	                        AlumnoInvalidoException.class,
	                        () -> alumnoService.guardar(alumno)
	                );
	            }
	            
	            @Test
	            void debeGuardarAlumnoValido() {

	                Alumno alumno = new Alumno(
	                        "Ana",
	                        "Perez",
	                        "12345678",
	                        "12345678",
	                        "5",
	                        "A",
	                        "Mañana"
	                );
	                
	                alumno.completarDatos(
	                        "15/05/2010",
	                        "ana@email.com",
	                        "1122334455"
	                );

	                org.mockito.Mockito.when(alumnoRepository.save(alumno))
	                        .thenReturn(alumno);

	                Alumno resultado = alumnoService.guardar(alumno);

	                assertNotNull(resultado);
	                assertEquals("12345678", resultado.getDni());
	                assertEquals("Ana", resultado.getNombre());

	                org.mockito.Mockito.verify(alumnoRepository).save(alumno);
	            }
	            
}
